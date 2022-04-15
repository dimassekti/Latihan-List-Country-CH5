package com.coufie.latihanretrofitch5.network

import com.coufie.latihanretrofitch5.model.getAllCountryResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET ("all")
    fun getAllCountry() : Call<List<getAllCountryResponseItem>>
}
