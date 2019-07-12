package com.example.cbanda.achieve.models.repository

import com.example.cbanda.achieve.models.db.Quote
import com.example.cbanda.achieve.utilities.ApiUtils
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class QuoteRepositoryImpl : QuoteRepository {
    private val quoteApiService: QuoteApiService = ApiUtils.getQuoteApiInterface()

    override fun getQuote(): Flowable<Quote> {

        return quoteApiService.getQuotes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}






