package dev.franco.vixapp.ui.splash

import androidx.compose.runtime.Composable
import androidx.media3.common.util.UnstableApi

@UnstableApi
@Composable
internal fun SplashContent(
    onMediaEnd: () -> Unit,
) {
    VideoPlayer() {
        onMediaEnd.invoke()
    }
}
