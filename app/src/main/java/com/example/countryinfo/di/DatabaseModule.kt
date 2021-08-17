package com.example.countryinfo.di

import android.app.Application
import androidx.room.Room
import com.example.countryinfo.data.CountryInfoRepo
import com.example.countryinfo.data.local.CountryInfoDao
import com.example.countryinfo.data.local.CountryInfoDatabase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): CountryInfoDatabase =
        Room.databaseBuilder(application, CountryInfoDatabase::class.java, "CountryInfoDatabase")
        .fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun providesDao(db: CountryInfoDatabase): CountryInfoDao = db.getDao()



}