package com.alidouiri.technicaltest.ui.features.show.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alidouiri.technicaltest.ui.features.show.list.ShowListViewModel
import com.alidouiri.technicaltest.ui.features.show.list.ShowsListScreen
import com.alidouiri.technicaltest.ui.features.show.live.LiveShowScreen
import kotlinx.serialization.Serializable

@Serializable
object ShowListRoute

@Serializable
internal data class LiveShowRoute(val id: String)


/**
 * Extension function to add the show list screen to the navigation graph
 */
internal fun NavGraphBuilder.showListScreen(onItemClick: (String) -> Unit) {
    composable<ShowListRoute>(
        exitTransition = { slideOutToLeft() },
        popEnterTransition = { slideInFromLeft() }
    ) {

        val showListViewModel = hiltViewModel<ShowListViewModel>()
        val uiState by showListViewModel.uiState.collectAsStateWithLifecycle()

        ShowsListScreen(
            uiState = uiState,
            onShowClick = { showId ->
                onItemClick(showId)
            }
        )
    }
}

/**
 * Extension function to add the live show screen to the navigation graph
 */
internal fun NavGraphBuilder.liveShowScreen() {
    composable<LiveShowRoute>(
        enterTransition = { slideInFromRight() },
        popExitTransition = { slideOutToRight() }
    ) {
        LiveShowScreen()
    }
}