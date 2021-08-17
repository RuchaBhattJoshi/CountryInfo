package com.example.countryinfo.di

import com.example.countryinfo.data.CountryInfoRepo
import com.example.countryinfo.data.local.CountryInfoDao
import com.example.countryinfo.data.remote.CountryInfoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


//que: 1 what 2 why 3 how

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(countryInfoDao: CountryInfoDao, countryInfoApi: CountryInfoApi
    ): CountryInfoRepo = CountryInfoRepo(countryInfoDao,countryInfoApi)

}