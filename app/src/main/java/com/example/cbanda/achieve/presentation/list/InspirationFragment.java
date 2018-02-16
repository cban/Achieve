package com.example.cbanda.achieve.presentation.list;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cbanda.achieve.R;
import com.example.cbanda.achieve.models.db.Quote;
import com.example.cbanda.achieve.utilities.ApiUtils;
import com.example.cbanda.achieve.models.repository.QuoteApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class InspirationFragment extends Fragment {

    QuoteApiService quoteApiService = ApiUtils.getQuoteApiInterface();
    private String mParam1;
    private String mParam2;
    private TextView textViewInspiration;
    private TextView textViewAuthor;


    private OnFragmentInteractionListener mListener;

    public InspirationFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadQuote();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inspiration, container, false);
        textViewInspiration = view.findViewById(R.id.textview_inspiration);
        textViewAuthor = view.findViewById(R.id.textview_author);
        return view;
    }

    public void loadQuote() {
        quoteApiService.getQuotes().enqueue(new Callback<Quote>() {
            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {
                if (response.isSuccessful()) {
                    textViewInspiration.setText("\" " + response.body().getQuoteText() + " \" ");
                    textViewAuthor.setText(response.body().getQuoteAuthor());
                }
            }
            @Override
            public void onFailure(Call<Quote> call, Throwable t) {
                call.cancel();
            }
        });

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
