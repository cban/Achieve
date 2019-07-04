package com.example.cbanda.achieve.presentation.inspiration

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

import com.example.cbanda.achieve.models.db.Quote
import com.example.cbanda.achieve.models.repository.QuoteRepository
import com.example.cbanda.achieve.models.repository.QuoteRepositoryImpl
import com.example.cbanda.achieve.utilities.InjectorUtils


class InspirationViewModel(application: Application) : AndroidViewModel(application) {
    private val quoteRepository: QuoteRepository = InjectorUtils.instance
    internal var quoteLiveData = MutableLiveData<Quote>()

    internal fun getQuote() {
        quoteRepository.getQuote(object : QuoteRepositoryImpl.QuoteCallback {
            override fun onSuccess(quote: Quote?) {
                quoteLiveData.postValue(quote)
            }
            override fun onError(exception: Throwable) {
            TODO("error handling")
            }
        })
    }
}
