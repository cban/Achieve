package com.example.cbanda.achieve.presentation.inspiration

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cbanda.achieve.models.db.Quote
import com.example.cbanda.achieve.models.repository.QuoteRepository
import com.example.cbanda.achieve.utilities.InjectorUtils
import io.reactivex.disposables.CompositeDisposable


class InspirationViewModel(application: Application) : AndroidViewModel(application) {
    private val quoteRepository: QuoteRepository = InjectorUtils.instance
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    internal val errorMessage = MutableLiveData<String>()
    internal var quoteLiveData = MutableLiveData<Quote>()

    internal fun getQuote() {
        compositeDisposable.add(quoteRepository.getQuote().subscribe({
            quoteLiveData.postValue(it)
        },
                {
                    handleException(it)
                }))
    }

    private fun handleException(it: Throwable?) {
        if (it is retrofit2.HttpException) {
            when (it.code()) {
                400 -> {
                    errorMessage.value = "Error 400"
                }
                401 -> {
                    errorMessage.value = "Error 401"
                }
                403 -> {
                    errorMessage.value = "Error 403"
                }
                404 -> {
                    errorMessage.value = "Error 404"
                }
                500 -> {
                    errorMessage.value = "Error 500"
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}

