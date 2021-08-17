package com.example.countryinfo.ui.theme.countrylist

import androidx.lifecycle.*
import com.example.countryinfo.data.CountryInfoRepo
import com.example.countryinfo.data.models.CountryInfo
import com.example.countryinfo.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CountryListViewModel
@Inject
constructor(private val repo: CountryInfoRepo) : ViewModel() {

    fun getAllCountryList(): LiveData<Resource<List<CountryInfo>>> = repo.getCountryInfo()

}