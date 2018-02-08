package com.example.cbanda.achieve.Views;

import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.cbanda.achieve.Models.db.Converters.DateConverter;
import com.example.cbanda.achieve.R;
import com.example.cbanda.achieve.ViewModels.AddGoalViewModel;
import com.example.cbanda.achieve.Views.Fragments.DatePickerFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddGoalActivity extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener {
    EditText description;
    EditText start_date;
    EditText end_date;
    RadioGroup radioGroup;
    Button buttonSave;
    private DatePickerFragment newFragment;
    AddGoalViewModel addGoalViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        description=findViewById(R.id.decription_edittext);
        start_date = findViewById(R.id.startDateEditText);
        end_date = findViewById(R.id.endDateEditText);
        buttonSave=findViewById(R.id.save_button);
        radioGroup=findViewById(R.id.priority_radioGroup);

        newFragment = new DatePickerFragment();
        addGoalViewModel = ViewModelProviders.of(this).get(AddGoalViewModel.class);

    }


    public String getRadioButtonText()
    {

        // get selected radio button from radioGroup
        int selectedId = radioGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        RadioButton radioButton =  findViewById(selectedId);
        return radioButton.getText().toString();
    }


    public void SaveToDB()
    {
        buttonSave.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {


            String briefDescription = description.getText().toString();

            //addGoalViewModel.addGoal(briefDescription,getRadioButtonText(),);
            finish();




        }
        });


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
    //    getStartDate(start_date.setText(format.format(calendar.getTime())));

        if (newFragment.getFlag() == DatePickerFragment.FLAG_START_DATE) {
            start_date.setText(format.format(calendar.getTime()));
            start_date.getText().toString();
        } else {
            end_date.setText(format.format(calendar.getTime()));



        }
    }





}