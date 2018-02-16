package com.example.cbanda.achieve.models.repository;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuoteApiClient {


    private static Retrofit retrofit = null;
    public static final String BASE_URL = "http://api.forismatic.com/api/1.0/";

    public static Retrofit getClient(String baseUrl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
