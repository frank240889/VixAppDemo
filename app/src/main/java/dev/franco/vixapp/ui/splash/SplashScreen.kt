package dev.franco.vixapp.ui.splash

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.media3.common.util.UnstableApi
import androidx.navigation.NavHostController
import dev.franco.vixapp.ui.Navigation.LIST

@UnstableApi
@Composable
internal fun SplashScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Transparent,
    ) {
        SplashContent() {
            navController.popBackStack()
            navController.navigate(LIST)
        }
    }
}
