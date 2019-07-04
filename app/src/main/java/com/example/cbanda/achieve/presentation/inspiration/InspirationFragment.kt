package com.example.cbanda.achieve.presentation.inspiration

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cbanda.achieve.R


class InspirationFragment : Fragment() {

    private lateinit var textViewInspiration: TextView
    private lateinit var textViewAuthor: TextView
    private lateinit var inspirationViewModel: InspirationViewModel
    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_inspiration, container, false)
        textViewInspiration = view.findViewById(R.id.textview_inspiration)
        textViewAuthor = view.findViewById(R.id.textview_author)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        loadQuote()
    }

    private fun setupViewModel() {
        inspirationViewModel = ViewModelProviders.of(requireActivity()).get(InspirationViewModel::class.java)
    }

    private fun loadQuote() {
        inspirationViewModel.getQuote()
        inspirationViewModel.quoteLiveData.observe(this, Observer { quote ->
          quote.let {
            textViewInspiration.text = String.format("\" %s \" ", quote.quoteText)
            textViewAuthor.text = quote.quoteAuthor}
        })
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }
}
