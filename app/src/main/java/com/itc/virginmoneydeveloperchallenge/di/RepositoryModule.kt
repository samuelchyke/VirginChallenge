package com.itc.virginmoneydeveloperchallenge.di

import com.itc.virginmoneydeveloperchallenge.repository.VirginRepository
import com.itc.virginmoneydeveloperchallenge.repository.VirginRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideVirginRepository(virginRepositoryImpl: VirginRepositoryImpl): VirginRepository

}