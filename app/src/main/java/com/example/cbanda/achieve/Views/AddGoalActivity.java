package com.example.cbanda.achieve.Views;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.cbanda.achieve.MainActivity;
import com.example.cbanda.achieve.R;
import com.example.cbanda.achieve.Views.Fragments.DatePickerFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddGoalActivity extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener {
    EditText start_date;
    EditText end_date;
    private DatePickerFragment newFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        start_date = findViewById(R.id.startDateEditText);
        end_date = findViewById(R.id.endDateEditText);
        newFragment = new DatePickerFragment();
    }

    public void showDatePickerDialog(View v) {

        newFragment.show(getSupportFragmentManager(), "datePicker");

    }

    public void selectStartAndEndDate(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.startDateEditText:
                start_date.setInputType(InputType.TYPE_NULL);
                start_date.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        newFragment.setFlag(DatePickerFragment.FLAG_START_DATE);
                        showDatePickerDialog(v);

                    }
                });
                start_date.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus) {
                            newFragment.setFlag(DatePickerFragment.FLAG_START_DATE);
                            showDatePickerDialog(v);
                        }
                    }
                });

            case R.id.endDateEditText:
                end_date.setInputType(InputType.TYPE_NULL);
                end_date.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        newFragment.setFlag(DatePickerFragment.FLAG_END_DATE);
                        showDatePickerDialog(v);

                    }
                });
                start_date.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus) {
                            newFragment.setFlag(DatePickerFragment.FLAG_END_DATE);
                            showDatePickerDialog(v);
                        }
                    }
                });
        }
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (newFragment.getFlag() == DatePickerFragment.FLAG_START_DATE) {
            start_date.setText(format.format(calendar.getTime()));
        } else {
            end_date.setText(format.format(calendar.getTime()));
            //   dateEditTextView.setText("Year: "+view.getYear()+" Month: "+view.getMonth()+" Day: "+view.getDayOfMonth());


        }
    }
}