package com.alidouiri.technicaltest.domain.repository

import com.alidouiri.technicaltest.domain.model.Show

/**
 * This repository serves as a fake implementation, simulating the asynchronous process
 * of data fetching before returning a predefined list of shows
 */
internal interface FakeShowRepository {
    suspend fun getShows(): List<Show>
}