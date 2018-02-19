package com.example.cbanda.achieve.models.repository;


import android.util.Log;

import com.example.cbanda.achieve.models.db.Quote;
import com.example.cbanda.achieve.utilities.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuoteRepositoryImpl implements QuoteRepository {
    private QuoteApiService quoteApiService;
    private Quote quote;

    public QuoteRepositoryImpl() {

        quoteApiService = ApiUtils.getQuoteApiInterface();
    }

    public void getQuote(final QuoteCallback quoteCallback) {
        quoteApiService.getQuotes().enqueue(new Callback<Quote>() {
            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {
                Log.d("QuoteRepository", "onResponse");
                if (response.isSuccessful()) {
                    quoteCallback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<Quote> call, Throwable t) {
                call.cancel();
                quoteCallback.onError(t);
            }
        });
    }

    public interface QuoteCallback {
        void onSuccess(Quote quote);

        void onError(Throwable exception);
    }

}






