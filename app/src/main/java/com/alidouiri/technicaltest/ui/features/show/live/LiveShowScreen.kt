package com.alidouiri.technicaltest.ui.features.show.live

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alidouiri.technicaltest.R
import com.alidouiri.technicaltest.designsystem.theme.TechnicalTestTheme
import kotlinx.coroutines.delay

@Composable
internal fun LiveShowScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        LikeButtonMicroInteraction()
    }
}

@Composable
private fun BoxScope.LikeButtonMicroInteraction() {
    var isLiked by remember { mutableStateOf(false) }
    val haptic = LocalHapticFeedback.current

    val scale by animateFloatAsState(
        targetValue = if (isLiked) 1.2f else 1.0f,
        animationSpec = tween(durationMillis = 100)
    )

    LaunchedEffect(isLiked) {
        if (isLiked) {
            delay(100)
            isLiked = false
        }
    }

    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(R.drawable.image),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )

    IconButton(
        onClick = {
            haptic.performHapticFeedback(HapticFeedbackType.ToggleOn)
            isLiked = true
        },
        modifier = Modifier
            .padding(32.dp)
            .scale(scale)
            .align(Alignment.BottomEnd)
    ) {
        Icon(
            imageVector = if (isLiked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
            contentDescription = "Like",
            tint = if (isLiked) Color.Red else Color.White,
            modifier = Modifier.size(48.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun LiveShowScreenPreview() {
    TechnicalTestTheme {
        LiveShowScreen()
    }
}