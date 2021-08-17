package com.example.countryinfo.data.remote

import com.example.countryinfo.data.models.CountryInfo
import com.example.countryinfo.data.models.CountryList
import retrofit2.http.GET

interface CountryInfoApi {
        @GET("v2/all")
        suspend fun fetchCountryInfoList(): List<CountryInfo>
    }
