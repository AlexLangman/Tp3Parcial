package com.example.parcialtp3langmanpoltibohuier.ui.components.drawer
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import kotlinx.coroutines.launch
import androidx.compose.ui.Alignment
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlin.math.roundToInt

@Composable
fun CustomDrawerRightToLeft(
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    scrimColor: Color = Color.Black.copy(alpha = 0.5f),
    drawerContent: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val density = LocalDensity.current

    val drawerWidth = with(density) { screenWidth.toPx() }

    val offset by animateFloatAsState(
        targetValue = if (drawerState.isOpen) 0f else drawerWidth,
        animationSpec = tween(durationMillis = 300)
    )

    Box(modifier = Modifier.fillMaxSize()) {
        content()

        if (drawerState.isOpen) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(scrimColor)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onPress = {
                                scope.launch {
                                    drawerState.close()
                                }
                            }
                        )
                    }
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(screenWidth)
                .offset { IntOffset(offset.roundToInt(), 0) }
                .background(MaterialTheme.colorScheme.background)
                .align(Alignment.CenterEnd)
                .zIndex(1f)
        ) {
            drawerContent()
        }
    }
}