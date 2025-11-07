package com.alidouiri.technicaltest.ui.features.show.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween

private const val TRANSITION_DURATION = 400

/**
 * Standard enter transition for a Forward movement
 *
 * The screen slides in from the right
 */
fun AnimatedContentTransitionScope<*>.slideInFromRight(): EnterTransition {
    return slideIntoContainer(
        AnimatedContentTransitionScope.SlideDirection.Start,
        animationSpec = tween(TRANSITION_DURATION)
    )
}

/**
 * Standard exit transition for a Forward movement (Push)
 *
 * The screen slides in from the right
 */
fun AnimatedContentTransitionScope<*>.slideOutToLeft(): ExitTransition {
    return slideOutOfContainer(
        AnimatedContentTransitionScope.SlideDirection.Start,
        animationSpec = tween(TRANSITION_DURATION)
    )
}

/**
 * Standard exit transition for a Forward movement (Push)
 *
 * The screen slides out to the left
 */
fun AnimatedContentTransitionScope<*>.slideInFromLeft(): EnterTransition {
    return slideIntoContainer(
        AnimatedContentTransitionScope.SlideDirection.End,
        animationSpec = tween(TRANSITION_DURATION)
    )
}

/**
 * Standard exit transition for a Backward movement (Pop)
 *
 * The screen slides out to the right
 */
fun AnimatedContentTransitionScope<*>.slideOutToRight(): ExitTransition {
    return slideOutOfContainer(
        AnimatedContentTransitionScope.SlideDirection.End,
        animationSpec = tween(TRANSITION_DURATION)
    )
}