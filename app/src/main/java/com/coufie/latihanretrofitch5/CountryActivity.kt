package com.coufie.latihanretrofitch5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.coufie.latihanretrofitch5.adapter.CountryAdapter
import com.coufie.latihanretrofitch5.model.getAllCountryResponseItem
import com.coufie.latihanretrofitch5.network.ApiClient
import kotlinx.android.synthetic.main.activity_country.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        getDataCountry()

    }

    fun getDataCountry(){
        ApiClient.instance.getAllCountry()
            .enqueue(object : Callback<List<getAllCountryResponseItem>>{
                override fun onResponse(
                    call: Call<List<getAllCountryResponseItem>>,
                    response: Response<List<getAllCountryResponseItem>>
                ) {
                    if (response.isSuccessful){
                        val dataCountry = response.body()
                        val adapterCountry = CountryAdapter(dataCountry!!)
                        val lm = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

                        rv_countries.layoutManager = lm
                        rv_countries.adapter = adapterCountry
                    }else{
                        Toast.makeText(this@CountryActivity, "gagal", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<List<getAllCountryResponseItem>>, t: Throwable) {
                    Toast.makeText(this@CountryActivity, "gagal", Toast.LENGTH_SHORT).show()
                }

            })
    }

    override fun onResume() {
        super.onResume()
        getDataCountry()
    }

    override fun onDestroy() {
        super.onDestroy()
        getDataCountry()
    }

}