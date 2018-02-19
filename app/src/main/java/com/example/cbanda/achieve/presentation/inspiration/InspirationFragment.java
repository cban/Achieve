package com.example.cbanda.achieve.presentation.inspiration;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cbanda.achieve.R;
import com.example.cbanda.achieve.models.db.Quote;
import com.example.cbanda.achieve.models.repository.QuoteApiService;
import com.example.cbanda.achieve.utilities.ApiUtils;


public class InspirationFragment extends Fragment {

    QuoteApiService quoteApiService = ApiUtils.getQuoteApiInterface();
    private String mParam1;
    private String mParam2;
    private TextView textViewInspiration;
    private TextView textViewAuthor;
    InspirationViewModel inspirationViewModel;
    Quote quote;

    private OnFragmentInteractionListener mListener;

    public InspirationFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViewModel();
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


    public void setupViewModel() {
        inspirationViewModel = ViewModelProviders.of(getActivity()).get(InspirationViewModel.class);
    }

    public void loadQuote() {

        inspirationViewModel.getQuote();
        inspirationViewModel.quoteLiveData.observe(this, new Observer<Quote>() {
            @Override
            public void onChanged(@Nullable Quote quote) {
                textViewInspiration.setText("\" " + quote.getQuoteText() + " \" ");
                textViewAuthor.setText(quote.getQuoteAuthor());
            }
        });

       /* if (quote != null) {
            textViewInspiration.setText("\" " + quote.getQuoteText() + " \" ");
            textViewAuthor.setText(quote.getQuoteAuthor());
        }*/
       /* quoteApiService.getQuotes().enqueue(new Callback<Quote>() {
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
*/
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
