package com.example.cbanda.achieve.presentation.add;

import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.cbanda.achieve.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddGoalActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    EditText goalDescriptionEditText;
    Button startDateButton;
    Button endDateButton;
    RadioGroup priorityRadioGroup;
    Button saveButton;
    private DatePickerFragment datePickerFragment;

    AddGoalViewModel addGoalViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeViews();
        addGoalViewModel = ViewModelProviders.of(this).get(AddGoalViewModel.class);
        SaveToDb();
    }

    private void initializeViews() {
        goalDescriptionEditText = findViewById(R.id.decription_edittext);
        startDateButton = findViewById(R.id.startDateButton);
        endDateButton = findViewById(R.id.endDateButton);
        saveButton = findViewById(R.id.save_button);
        priorityRadioGroup = findViewById(R.id.priority_radioGroup);
        datePickerFragment = new DatePickerFragment();
    }

    public String getRadioButtonText() {
        // get selected radio button from radioGroup
        int selectedId = priorityRadioGroup.getCheckedRadioButtonId();
        // find the radiobutton by the returned id
        RadioButton radioButton = findViewById(selectedId);
        return radioButton.getText().toString();
    }

    public void SaveToDb() {
        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String goalDescription = goalDescriptionEditText.getText().toString();
                addGoalViewModel.setGoalDescription(goalDescription);
                addGoalViewModel.setPrioritySelected(getRadioButtonText());
                addGoalViewModel.addGoal();

                finish();
            }
        });
    }

    public void showDatePickerDialog() {
        datePickerFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void selectStartAndEndDate(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.startDateButton:
                datePickerFragment.setFlag(DatePickerFragment.FLAG_START_DATE);
                showDatePickerDialog();

            case R.id.endDateButton:
                endDateButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        datePickerFragment.setFlag(DatePickerFragment.FLAG_END_DATE);
                        showDatePickerDialog();

                    }
                });

        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        if (datePickerFragment.getFlag() == DatePickerFragment.FLAG_START_DATE) {
            startDateButton.setText(format.format(calendar.getTime()));
            addGoalViewModel.setSelectedStartDate(calendar.getTime());

        } else {
            endDateButton.setText(format.format(calendar.getTime()));
            addGoalViewModel.setSelectedEndDate(calendar.getTime());
        }
    }


}