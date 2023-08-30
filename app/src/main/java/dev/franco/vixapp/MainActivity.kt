package dev.franco.vixapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import androidx.media3.common.util.UnstableApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import dev.franco.vixapp.ui.Navigation
import dev.franco.vixapp.ui.Navigation.DETAIL
import dev.franco.vixapp.ui.Navigation.LIST
import dev.franco.vixapp.ui.Navigation.SPLASH
import dev.franco.vixapp.ui.detail.DetailScreen
import dev.franco.vixapp.ui.main.MainScreen
import dev.franco.vixapp.ui.main.MainViewModel
import dev.franco.vixapp.ui.splash.SplashScreen
import dev.franco.vixapp.ui.theme.VixAppTheme

@UnstableApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val navController = rememberNavController()
            val systemUiController = rememberSystemUiController()
            val useDarkIcons = true

            DisposableEffect(systemUiController, useDarkIcons) {
                systemUiController.setSystemBarsColor(
                    color = Color.Transparent,
                    darkIcons = useDarkIcons,
                    isNavigationBarContrastEnforced = false,
                )
                onDispose {}
            }
            VixAppTheme {
                NavHost(navController = navController, startDestination = Navigation.SPLASH) {
                    composable(SPLASH) {
                        SplashScreen(
                            navController,
                        )
                    }
                    composable(LIST) {
                        MainScreen(navController, mainViewModel)
                    }
                    composable(
                        route = "$DETAIL/{nodeId}/{id}",
                        arguments = listOf(
                            navArgument("nodeId") { type = NavType.StringType },
                            navArgument("id") { type = NavType.StringType },
                        ),
                    ) {
                        DetailScreen(
                            navController,
                            it.arguments?.getString("nodeId"),
                            it.arguments?.getString("id"),
                        )
                    }
                }
            }
        }
    }
}
