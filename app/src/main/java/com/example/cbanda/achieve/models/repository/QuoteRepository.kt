package com.example.cbanda.achieve.models.repository


interface QuoteRepository {

    fun getQuote(quoteCallback: QuoteRepositoryImpl.QuoteCallback)

}
