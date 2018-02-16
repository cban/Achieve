package com.example.cbanda.achieve.models.repository;


public interface QuoteRepository {

    void getQuote(QuoteRepositoryImpl.QuoteCallback quoteCallback);

}
