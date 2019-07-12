package com.example.cbanda.achieve.utilities


import com.example.cbanda.achieve.models.repository.QuoteApiClient
import com.example.cbanda.achieve.models.repository.QuoteApiService

object ApiUtils {
    private const val BASE_URL = "http://api.forismatic.com/api/1.0/"

    fun getQuoteApiInterface():QuoteApiService {
        return QuoteApiClient.getClient(BASE_URL).create(QuoteApiService::class.java)
    }

}