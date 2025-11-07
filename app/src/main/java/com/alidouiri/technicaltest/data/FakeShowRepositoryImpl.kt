package com.alidouiri.technicaltest.data

import com.alidouiri.technicaltest.data.model.ShowEntity
import com.alidouiri.technicaltest.domain.model.Show
import com.alidouiri.technicaltest.domain.repository.FakeShowRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

/**
 * This repository serves as a fake implementation, simulating the asynchronous process
 * of data fetching before returning a predefined list of shows
 */
internal class FakeShowRepositoryImpl @Inject constructor() : FakeShowRepository {

    override suspend fun getShows(): List<Show> {

        delay(1200) // simulate network

        return listOf(
            ShowEntity(
                id = "1",
                title = "Sneaker Drop Live",
                viewers = 1200
            ),
            ShowEntity(
                id = "2",
                title = "Gadget Flash Sale",
                viewers = 890
            ),
            ShowEntity(
                id = "3",
                title = "Streetwear Auction",
                viewers = 1530
            )
        ).map {
            Show(id = it.id, thumbnailUrl = it.thumbnailUrl, title = it.title, viewers = it.viewers)
        }
    }
}