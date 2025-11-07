package com.alidouiri.technicaltest.domain.usecase

import com.alidouiri.technicaltest.domain.model.Show
import com.alidouiri.technicaltest.domain.repository.FakeShowRepository
import javax.inject.Inject

/**
 * This use cas return a list of shows
 */
internal class ShowListUseCase @Inject constructor(
    val repository: FakeShowRepository
) {

    suspend operator fun invoke(): List<Show> = repository.getShows()

}