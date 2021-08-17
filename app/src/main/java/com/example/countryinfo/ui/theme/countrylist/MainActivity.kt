package com.example.countryinfo.ui.theme.countrylist

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countryinfo.R
import com.example.countryinfo.adaptr.RecyclerViewAdapter
import com.example.countryinfo.data.CountryInfoRepo
import com.example.countryinfo.data.models.CountryInfo
import com.example.countryinfo.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var countryInfoRepo: CountryInfoRepo
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        initMainViewModel()
    }


    private fun init() {

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)

//            val decoration  =  DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
//            addItemDecoration(decoration)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter =recyclerViewAdapter
        }
    }

    private  fun initMainViewModel() {
        val viewModel  = ViewModelProvider(this).get(CountryListViewModel::class.java)
        viewModel.getAllCountryList().observe(this) {
            when (it) {
                is Resource.Success -> {
                    recyclerViewAdapter.setListData(it.data)
                    Log.d("response",it.toString())
                    recyclerViewAdapter.notifyDataSetChanged()
                }
                else -> {
                    Log.d("error","error")
                }
            }
        }

    }


}