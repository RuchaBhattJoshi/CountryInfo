package com.example.countryinfo.adaptr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countryinfo.R
import com.example.countryinfo.data.models.CountryInfo
import kotlinx.android.synthetic.main.repo_list_view.view.*

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var listData: List<CountryInfo>? = null
    fun setListData(listData: List<CountryInfo>?) {
        this.listData = listData
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.repo_list_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if(listData == null )return 0
        return listData?.size!!
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
       // val image_avatar_url = view.image_avatar_url
        val tvName = view.tvName
        val tvDesc = view.tvDesc

        fun bind(data: CountryInfo) {
            tvName.text = data.name
            tvDesc.text = data.capital

        }
    }
}
