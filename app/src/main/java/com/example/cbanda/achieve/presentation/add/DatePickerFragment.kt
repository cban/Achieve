package com.example.cbanda.achieve.presentation.add

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

import java.util.Calendar

class DatePickerFragment : DialogFragment() {


    var flag = 0

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val calendar = Calendar.getInstance()
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)

        return if (activity != null)
            DatePickerDialog(activity!!, activity as DatePickerDialog.OnDateSetListener?, year, month, dayOfMonth)
        else
            super.onCreateDialog(savedInstanceState)
    }

    companion object {

        const val FLAG_START_DATE = 0
        const val FLAG_END_DATE = 1
    }

}


