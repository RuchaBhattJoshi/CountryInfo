package com.example.countryinfo.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.countryinfo.data.local.CountryInfoDao
import com.example.countryinfo.data.models.CountryInfo
import com.example.countryinfo.data.models.CountryList
import com.example.countryinfo.data.remote.CountryInfoApi
import com.example.countryinfo.utils.Resource
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CountryInfoRepo
@Inject
constructor(
    private val dao: CountryInfoDao,
    private val countryInfoApi: CountryInfoApi
    ){

    //local
    fun getCountryInfo(): LiveData<Resource<List<CountryInfo>>> {
        CoroutineScope(Dispatchers.IO).launch {
            val response = makeApiCall()
            if(response is Resource.Success){
                //response.data?.let { dao.insertAll(it) }
                response.data?.forEach {
                    dao.insertCountryInfo(it)
                    delay(200)
                }
            }
            else{
               Log.d("api call fail","fail")
            }
        }

       return dao.getAllCountryInfo().map {
           if(it.isEmpty()){
            Resource.Error("No Data in Database")
           } else{
               Resource.Success(it)
           }
       }

    }

    suspend fun insert(countryInfo: CountryInfo) = withContext(Dispatchers.IO){
        dao.insertCountryInfo(countryInfo)
    }


    //network
    private suspend fun makeApiCall() : Resource<List<CountryInfo>>{
        val response  = try{
            countryInfoApi.fetchCountryInfoList()
        }catch(e:Exception){
            return Resource.Error("An Unknown error occured.")
        }
        return Resource.Success(response)
    }


    }





//    suspend fun getAllCountryInfo(): CountryInfo {
//        /** As per requirement we will fetch data from the database first **/
//        val countryInfoListDB = dao.getAllCountryInfo()
//
//        /** If record found then we will return that records **/
//        if(countryInfoListDB != null ){
//            return countryInfoListDB
//        }
//
//        /**
//         *  If no record found from database then we will call webservice.
//         *  Now we will store data which we will get from webservice
//         *  Now we will return data
//         */
//        val countryInfoList = countryInfoApi.fetchCountryInfoList()
//        dao.insertCountryInfo(countryInfoList)
//        return countryInfoList
//    }