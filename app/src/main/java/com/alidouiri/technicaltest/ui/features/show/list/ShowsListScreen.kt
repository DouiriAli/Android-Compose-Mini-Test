package com.alidouiri.technicaltest.ui.features.show.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alidouiri.technicaltest.R
import com.alidouiri.technicaltest.designsystem.component.shimmerEffect
import com.alidouiri.technicaltest.designsystem.theme.TechnicalTestTheme
import com.alidouiri.technicaltest.domain.model.Show
import com.alidouiri.technicaltest.ui.features.show.list.model.ShowListUiState

@Composable
internal fun ShowsListScreen(
    uiState: ShowListUiState,
    onShowClick: (String) -> Unit
) {
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        when (uiState) {
            ShowListUiState.Loading -> {
                items(5) {
                    ShowListItem(show = null, isLoading = true, onClick = {})
                }
            }

            is ShowListUiState.Success -> {
                val shows = uiState.showList
                items(shows) { show ->
                    ShowListItem(show = show, isLoading = false, onClick = onShowClick)
                }
            }

            is ShowListUiState.Error -> {
                item { DisplayError(uiState.messageRes) }
            }
        }
    }
}

@Composable
private fun ShowListItem(show: Show?, isLoading: Boolean, onClick: (String) -> Unit) {
    val modifier = if (isLoading) Modifier.shimmerEffect() else Modifier

    Card(
        onClick = { if (!isLoading && show != null) onClick(show.id) },
        modifier = Modifier
            .padding(vertical = 8.dp)
            .then(modifier)
    ) {

        Row(
            Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (!isLoading) {
                Image(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    painter = painterResource(R.drawable.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .background(Color.Gray, RoundedCornerShape(8.dp))
                )
            }

            Spacer(Modifier.width(16.dp))

            Column(Modifier.weight(1f)) {

                Box(
                    Modifier
                        .fillMaxWidth(if (isLoading) 0.7f else 1f)
                        .height(20.dp)
                        .background(if (isLoading) Color.LightGray else Color.Transparent)
                ) {
                    if (!isLoading) {
                        Text(
                            text = show?.title.orEmpty(),
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
                Spacer(Modifier.height(4.dp))

                Box(
                    Modifier
                        .fillMaxWidth(0.5f)
                        .height(14.dp)
                        .background(if (isLoading) Color.LightGray else Color.Transparent)
                ) {
                    if (!isLoading && show != null) {
                        Text(
                            text = stringResource(R.string.show_list_viewers, show.viewers),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun DisplayError(messageRes: Int) {
    Text(
        text = stringResource(messageRes)
    )
}

@Composable
@Preview(showBackground = true)
private fun ShowsListLoadingScreenPreview() {
    TechnicalTestTheme {
        ShowsListScreen(
            uiState = ShowListUiState.Loading,
            onShowClick = {}
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun ShowsListScreenPreview() {
    TechnicalTestTheme {
        ShowsListScreen(
            uiState = ShowListUiState.Success(
                showList = listOf(
                    Show(id = "1", title = "Sneaker Drop Live", viewers = 1200),
                    Show(id = "2", title = "Gadget Flash Sale", viewers = 890),
                    Show(id = "3", title = "Streetwear Auction", viewers = 1530)
                )
            ),
            onShowClick = {}
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun ShowsListErrorScreenPreview() {
    TechnicalTestTheme {
        ShowsListScreen(
            uiState = ShowListUiState.Error(R.string.error_message),
            onShowClick = {}
        )
    }
}

