package com.alidouiri.technicaltest.designsystem.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

/**
 * Applies a Shimmer loading effect to the Composable
 *
 * Usually within a conditional check like if (isLoading) Modifier.shimmerEffect()
 */
fun Modifier.shimmerEffect() = composed {
    val size = with(LocalDensity.current) { 1000.dp.toPx() }

    val infiniteTransition = rememberInfiniteTransition(label = "ShimmerTransition")

    val xShimmer by infiniteTransition.animateFloat(
        initialValue = -size,
        targetValue = size,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1500,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "ShimmerOffset"
    )

    val shimmerBrush = Brush.linearGradient(
        colors  = listOf(
            Color.LightGray.copy(alpha = 0.6f),
            Color.LightGray.copy(alpha = 0.2f),
            Color.Transparent
        ),
        start = Offset(xShimmer - size, 0f),
        end = Offset(xShimmer, 0f)
    )

    background(
        brush = shimmerBrush,
        shape = RoundedCornerShape(8.dp)
    )
}

