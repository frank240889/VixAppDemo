package dev.franco.vixapp.ui.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import dev.franco.vixapp.R
import dev.franco.vixapp.ui.components.NoContentAvailable
import dev.franco.vixapp.ui.components.VixSnackbarHost

@Composable
internal fun DetailScreen(
    navHostController: NavHostController,
    nodeId: String?,
    id: String?,
    detailViewModel: DetailViewModel = hiltViewModel(),
) {
    detailViewModel.nodeId = nodeId
    detailViewModel.id = id
    val snackbarHostState = remember { SnackbarHostState() }
    val contentDetail by remember { detailViewModel.detailContent }
    val error by remember { detailViewModel.error }

    LaunchedEffect(Unit) {
        detailViewModel.init()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        contentDetail?.let {
            DetailContent(contentDetail = contentDetail!!)
        }
        error?.let {
            NoContentAvailable()
            val label = stringResource(R.string.ok).uppercase()
            LaunchedEffect(Unit) {
                val state = snackbarHostState.showSnackbar(
                    message = it,
                    duration = SnackbarDuration.Short,
                    actionLabel = label,
                )
                if (state == SnackbarResult.Dismissed) {
                    navHostController.popBackStack()
                }
            }
        }

        VixSnackbarHost(
            snackbarHostState = snackbarHostState,
            modifier = Modifier
                .align(Alignment.BottomCenter),
        ) {
            navHostController.popBackStack()
        }
    }
}
