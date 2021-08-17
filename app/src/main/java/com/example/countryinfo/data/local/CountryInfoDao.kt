package com.example.countryinfo.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.countryinfo.data.models.CountryInfo
import com.example.countryinfo.data.models.CountryList
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountryInfo(countryInfo: CountryInfo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(countryList:List<CountryInfo>)

//    @Query("SELECT * FROM countryInfoTable")
//    fun getAllCountryInfo(): Flow<List<CountryInfo>>

    @Query("SELECT * FROM countryInfoTable")
    fun getAllCountryInfo(): LiveData<List<CountryInfo>>
}