package com.example.cbanda.achieve.presentation.inspiration;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.cbanda.achieve.models.db.Quote;
import com.example.cbanda.achieve.models.repository.QuoteRepository;
import com.example.cbanda.achieve.models.repository.QuoteRepositoryImpl;
import com.example.cbanda.achieve.utilities.InjectorUtils;


public class InspirationViewModel extends AndroidViewModel {
    QuoteRepository quoteRepository;
    MutableLiveData<Quote> quoteLiveData = new MutableLiveData<>();

    public InspirationViewModel(@NonNull Application application) {
        super(application);
        quoteRepository = InjectorUtils.getInstance();
    }

    public void getQuote() {
        quoteRepository.getQuote(new QuoteRepositoryImpl.QuoteCallback() {
            @Override
            public void onSuccess(Quote quote) {
                quoteLiveData.postValue(quote);
            }

            @Override
            public void onError(Throwable exception) {

            }
        });
    }
}
