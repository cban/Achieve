package com.example.cbanda.achieve.models.repository

import com.example.cbanda.achieve.models.db.Quote
import io.reactivex.Flowable
import retrofit2.http.GET

interface QuoteApiService {

    @GET("?method=getQuote&key=457653&format=json&lang=en")
    fun getQuotes(): Flowable<Quote>
}
