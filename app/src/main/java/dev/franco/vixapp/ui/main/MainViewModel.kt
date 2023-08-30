package dev.franco.vixapp.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.franco.vixapp.domain.CategoriesResult
import dev.franco.vixapp.domain.ContentResult
import dev.franco.vixapp.domain.MainContentResult
import dev.franco.vixapp.domain.UseCase
import dev.franco.vixapp.injection.CategoriesUseCase
import dev.franco.vixapp.injection.FreemiumContentUseCase
import dev.franco.vixapp.injection.MainContentUseCase
import dev.franco.vixapp.injection.PremiumContentUseCase
import dev.franco.vixapp.ui.data.model.main.ContentStreamModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @CategoriesUseCase private val fetchCategoriesUseCase: UseCase,
    @MainContentUseCase private val fetchMainContentUseCase: UseCase,
    @FreemiumContentUseCase private val fetchFreemiumContentUseCase: UseCase,
    @PremiumContentUseCase private val fetchPremiumContentUseCase: UseCase,
) : ViewModel() {
    val loading: MutableState<Boolean> = mutableStateOf(false)
    val categories: MutableState<List<String>> = mutableStateOf(emptyList())
    val mainContent: MutableState<List<ContentStreamModel>> = mutableStateOf(emptyList())
    val freemiumContent: MutableState<Pair<String, List<ContentStreamModel>>> = mutableStateOf(
        Pair("", emptyList()),
    )
    val premiumContent: MutableState<Pair<String, List<ContentStreamModel>>> = mutableStateOf(
        Pair("", emptyList()),
    )
    val error: MutableState<String?> = mutableStateOf(null)

    fun init() {
        viewModelScope.launch {
            loading.value = true
            fetchCategoriesUseCase.invoke().collect {
                when (it) {
                    is CategoriesResult.Success -> {
                        categories.value = it.categories
                    }

                    is CategoriesResult.Error -> {
                        error.value = it.message
                    }

                    else -> Unit
                }
            }
            fetchMainContentUseCase.invoke().collect {
                when (it) {
                    is MainContentResult.Success -> {
                        mainContent.value = it.mainContent
                    }

                    is MainContentResult.Error -> {
                        error.value = it.message
                    }

                    else -> Unit
                }
            }

            fetchFreemiumContentUseCase.invoke().collect {
                when (it) {
                    is ContentResult.Success -> {
                        freemiumContent.value = Pair(it.title, it.content)
                    }

                    is ContentResult.Error -> {
                        error.value = it.message
                    }

                    else -> Unit
                }
            }

            fetchPremiumContentUseCase.invoke().collect {
                when (it) {
                    is ContentResult.Success -> {
                        premiumContent.value = Pair(it.title, it.content)
                    }

                    is ContentResult.Error -> {
                        error.value = it.message
                    }

                    else -> Unit
                }
            }
            loading.value = false
        }
    }
}
