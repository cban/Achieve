package com.example.cbanda.achieve.utilities;


import com.example.cbanda.achieve.models.repository.QuoteApiClient;
import com.example.cbanda.achieve.models.repository.QuoteApiService;

public class ApiUtils {
    public static final String BASE_URL = "http://api.forismatic.com/api/1.0/";

    public static QuoteApiService getQuoteApiInterface() {
        return QuoteApiClient.getClient(BASE_URL).create(QuoteApiService.class);
    }
}