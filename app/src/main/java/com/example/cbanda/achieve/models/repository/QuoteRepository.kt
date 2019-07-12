package com.example.cbanda.achieve.models.repository

import com.example.cbanda.achieve.models.db.Quote
import io.reactivex.Flowable


interface QuoteRepository {

    fun getQuote(): Flowable<Quote>
}
