package dev.franco.vixapp.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.franco.vixapp.ui.Navigation.DETAIL

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun MainScreen(
    navHostController: NavHostController,
    viewModel: MainViewModel,
) {
    val loading by viewModel.loading
    val categories by viewModel.categories
    val mainContent by viewModel.mainContent
    val freemiumContent by viewModel.freemiumContent
    val premiumContent by viewModel.premiumContent

    LaunchedEffect(Unit) {
        viewModel.init()
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .semantics {
                testTagsAsResourceId = true
            },
        color = Color.Black,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            MainContent(
                onClickPremium = { },
                onClickSearch = { },
                onClickProfile = { },
                categories = categories,
                onClickCategory = {},
                mainContent = mainContent,
                onClickContent = { nodeId, id ->
                    navHostController.navigate("$DETAIL/$nodeId/$id")
                },
                freemiumContent = freemiumContent,
                onClickFreemiumContent = { nodeId, id ->
                    navHostController.navigate("$DETAIL/$nodeId/$id")
                },
                premiumContent = premiumContent,
                onClickPremiumContent = { nodeId, id ->
                    navHostController.navigate("$DETAIL/$nodeId/$id")
                },
            )
            if (loading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(48.dp)
                        .align(Alignment.Center),
                    color = Color.Red,
                )
            }
        }
    }
}
