package dev.franco.vixapp.ui.components

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BoxScope.VixSnackbarHost(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    onDismiss: () -> Unit = { },
) {
    SnackbarHost(
        modifier = modifier.align(Alignment.BottomCenter),
        hostState = snackbarHostState,
        snackbar = { snackbarData: SnackbarData ->
            Snackbar(
                modifier = Modifier.padding(16.dp),
                containerColor = Color.Red,
                contentColor = Color.White,
                shape = RoundedCornerShape(25),
                content = {
                    Text(
                        text = snackbarData.visuals.message,
                        color = Color.White,
                    )
                },
                action = {
                    snackbarData.visuals.actionLabel?.let { actionLabel ->
                        TextButton(onClick = onDismiss) {
                            Text(
                                text = actionLabel,
                                color = Color.LightGray,
                            )
                        }
                    }
                },
            )
        },
    )
}
