package com.example.cbanda.achieve.models.repository

import com.example.cbanda.achieve.models.db.Quote

import retrofit2.Call
import retrofit2.http.GET

interface QuoteApiService {

    @get:GET("?method=getQuote&key=457653&format=json&lang=en")
    val quotes: Call<Quote>

}
