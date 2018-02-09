package com.example.cbanda.achieve.presentation.add;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

/**
 * Created by CBanda on 2018/02/07.
 */


public class DatePickerFragment extends DialogFragment {

    public static final int FLAG_START_DATE = 0;
    public static final int FLAG_END_DATE = 1;


    private int flag = 0;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar calendar = Calendar.getInstance();
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        if (getActivity() != null)
            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, dayOfMonth);
        else
            return super.onCreateDialog(savedInstanceState);
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int i) {
        flag = i;
    }

}


