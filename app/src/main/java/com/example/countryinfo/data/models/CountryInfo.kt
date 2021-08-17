package com.example.countryinfo.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.security.acl.Owner


@Entity(tableName = "countryInfoTable")
data class CountryInfo(

    @ColumnInfo(name = "alpha2Code")
    @SerializedName("alpha2Code")
    val alpha2Code: String,

    @ColumnInfo(name = "alpha3Code")
    @SerializedName("alpha3Code")
    val alpha3Code: String,

    @ColumnInfo(name = "area")
    @SerializedName("area")
    val area: Double,

    @ColumnInfo(name = "capital")
    @SerializedName("capital")
    val capital: String,

    @ColumnInfo(name = "cioc")
    @SerializedName("cioc")
    val cioc: String?,

    @ColumnInfo(name = "demonym")
    @SerializedName("demonym")
    val demonym: String,

    @ColumnInfo(name = "flag")
    @SerializedName("flag")
    val flag: String,

    @ColumnInfo(name = "gini")
    @SerializedName("gini")
    val gini: Double,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String,

    @ColumnInfo(name = "nativeName")
    @SerializedName("nativeName")
    val nativeName: String,

    @ColumnInfo(name = "numericCode")
    @SerializedName("numericCode")
    val numericCode: String?,

    @ColumnInfo(name = "population")
    @SerializedName("population")
    val population: Int,

    @ColumnInfo(name = "region")
    @SerializedName("region")
    val region: String,

    @ColumnInfo(name = "subregion")
    @SerializedName("subregion")
    val subregion: String,

){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")var id:Int?= 0
}




