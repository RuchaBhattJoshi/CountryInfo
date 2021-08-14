package com.example.countryinfo.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.countryinfo.data.models.CountryInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountryInfo(countryInfo: CountryInfo)

    @Query("SELECT * FROM countryInfoTable")
    fun getAllCountryInfo(): Flow<List<CountryInfo>>


}