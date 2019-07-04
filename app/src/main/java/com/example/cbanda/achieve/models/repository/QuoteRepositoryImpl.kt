package com.example.cbanda.achieve.models.repository


import android.util.Log

import com.example.cbanda.achieve.models.db.Quote
import com.example.cbanda.achieve.utilities.ApiUtils

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuoteRepositoryImpl : QuoteRepository {
    private val quoteApiService: QuoteApiService = ApiUtils.getQuoteApiInterface()
    private val quote: Quote? = null

    override fun getQuote(quoteCallback: QuoteCallback) {
        quoteApiService.quotes.enqueue(object : Callback<Quote> {
            override fun onResponse(call: Call<Quote>, response: Response<Quote>) {
                Log.d("QuoteRepository", "onResponse")
                if (response.isSuccessful) {
                    quoteCallback.onSuccess(response.body())

                }
            }

            override fun onFailure(call: Call<Quote>, t: Throwable) {
                call.cancel()
                quoteCallback.onError(t)
            }
        })
    }

    interface QuoteCallback {
        fun onSuccess(quote: Quote?)

        fun onError(exception: Throwable)
    }

}






