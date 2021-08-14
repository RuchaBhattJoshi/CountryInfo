package com.example.countryinfo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.countryinfo.data.models.CountryInfo

@Database(entities = [CountryInfo::class], version = 1, exportSchema = false)
abstract class CountryInfoDatabase : RoomDatabase() {
    abstract fun getDao(): CountryInfoDao
}