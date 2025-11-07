package com.alidouiri.technicaltest.data.di

import com.alidouiri.technicaltest.data.FakeShowRepositoryImpl
import com.alidouiri.technicaltest.domain.repository.FakeShowRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    /**
     * Provides an instance of [FakeShowRepository]
     */
    @Binds
    internal abstract fun bindsFakeShowRepository(
        artWorkRepositoryImpl: FakeShowRepositoryImpl
    ): FakeShowRepository
}