package com.example.cbanda.achieve.presentation.add

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import com.example.cbanda.achieve.R
import com.example.cbanda.achieve.presentation.list.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class AddGoalActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
    private lateinit var goalDescriptionEditText: EditText
    private lateinit var startDateButton: Button
    private lateinit var endDateButton: Button
    private lateinit var priorityRadioGroup: RadioGroup
    private lateinit var saveButton: Button
    private var datePickerFragment: DatePickerFragment = DatePickerFragment()

    lateinit var addGoalViewModel: AddGoalViewModel

    // get selected radio button from radioGroup
    // find the radiobutton by the returned id
    private val radioButtonText: String
        get() {
            val selectedId = priorityRadioGroup.checkedRadioButtonId
            val radioButton = findViewById<RadioButton>(selectedId)
            return radioButton.text.toString()
        }

    val simpleDateFormat: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_goal)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        initializeViews()
        addGoalViewModel = ViewModelProviders.of(this).get(AddGoalViewModel::class.java)
        saveToDb()
    }

    private fun initializeViews() {
        goalDescriptionEditText = findViewById(R.id.decription_edittext)
        startDateButton = findViewById(R.id.startDateButton)
        endDateButton = findViewById(R.id.endDateButton)
        saveButton = findViewById(R.id.save_button)
        priorityRadioGroup = findViewById(R.id.priority_radioGroup)
        datePickerFragment = DatePickerFragment()
    }

    private fun saveToDb() {
        saveButton.setOnClickListener {
            val goalDescription = goalDescriptionEditText.text.toString()
            addGoalViewModel.goalDescription = goalDescription
            addGoalViewModel.prioritySelected = radioButtonText
            addGoalViewModel.addGoal()

            val intent = Intent(this@AddGoalActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showDatePickerDialog() {
        datePickerFragment.show(supportFragmentManager, "datePicker")
    }

    fun selectStartAndEndDate(v: View) {
        when (v.id) {
            R.id.startDateButton -> {
                datePickerFragment.flag = DatePickerFragment.FLAG_START_DATE
                showDatePickerDialog()
                endDateButton.setOnClickListener {
                    datePickerFragment.flag = DatePickerFragment.FLAG_END_DATE
                    showDatePickerDialog()
                }
            }

            R.id.endDateButton -> endDateButton.setOnClickListener {
                datePickerFragment.flag = DatePickerFragment.FLAG_END_DATE
                showDatePickerDialog()
            }
        }
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = getCalendar(year, month, dayOfMonth)
        val format = simpleDateFormat

        if (datePickerFragment.flag == DatePickerFragment.FLAG_START_DATE) {
            startDateButton.text = format.format(calendar.time)
            addGoalViewModel.selectedStartDate = calendar.time

        } else {
            endDateButton.text = format.format(calendar.time)
            addGoalViewModel.selectedEndDate = calendar.time
        }
    }

    private fun getCalendar(year: Int, month: Int, dayOfMonth: Int): Calendar {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        return calendar
    }


}