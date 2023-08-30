package dev.franco.vixapp.ui.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.franco.vixapp.R
import dev.franco.vixapp.domain.DetailContentResult
import dev.franco.vixapp.domain.UseCase
import dev.franco.vixapp.helpers.ResourceManager
import dev.franco.vixapp.injection.DetailContentUseCase
import dev.franco.vixapp.ui.data.model.detail.ContentDetailModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    @DetailContentUseCase private val fetchDetailsUseCase: UseCase,
    private val resourceManager: ResourceManager,
) : ViewModel() {
    val loading: MutableState<Boolean> = mutableStateOf(false)
    val detailContent: MutableState<ContentDetailModel?> = mutableStateOf(null)
    val error: MutableState<String?> = mutableStateOf(null)
    var nodeId: String? = null
    var id: String? = null

    fun init() {
        viewModelScope.launch {
            loading.value = true
            if (nodeId != null && id != null) {
                fetchDetailsUseCase.invoke(id!!).collect {
                    when (it) {
                        is DetailContentResult.Success -> {
                            detailContent.value = it.contentDetail
                        }

                        is DetailContentResult.Error -> {
                            error.value = it.message
                        }

                        else -> Unit
                    }
                }
            } else {
                error.value = resourceManager.getString(R.string.error)
            }
            loading.value = false
        }
    }
}
