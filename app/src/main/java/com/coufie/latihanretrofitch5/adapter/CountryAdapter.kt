package com.coufie.latihanretrofitch5.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.coufie.latihanretrofitch5.R
import com.coufie.latihanretrofitch5.model.getAllCountryResponseItem
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter (private var dataCountry : List<getAllCountryResponseItem>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>(){
    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.ViewHolder {
        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent , false)

        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: CountryAdapter.ViewHolder, position: Int) {
        holder.itemView.tv_countryname.text = "Name : ${dataCountry[position].name}"
        holder.itemView.tv_countrycapital.text =  "Capital : ${dataCountry[position].capital}"
        holder.itemView.tv_countryregion.text = "Region : ${dataCountry[position].region}"
        holder.itemView.tv_countrysubregion.text = "Sub Region : ${dataCountry[position].subregion}"

        this.let {
            Glide.with(holder.itemView.context).load(dataCountry[position].flags.png).into(holder.itemView.iv_image)
        }
    }

    override fun getItemCount(): Int {
        return dataCountry.size
    }
}