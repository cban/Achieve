package com.example.cbanda.achieve.presentation.detail

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cbanda.achieve.R
import org.joda.time.DateTime

class GoalDetailActivity : AppCompatActivity() {

    private lateinit var goalDetailViewModel: GoalDetailViewModel
    private lateinit var textViewDetailDescription: TextView
    private lateinit var textViewDetailPriority: TextView
    private lateinit var textViewStartDate: TextView
    private lateinit var textViewEndDate: TextView
    private lateinit var textViewDaysLeft: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goal_detail)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        initializeViews()
        val id = intent.extras!!.getInt("Goal")

        goalDetailViewModel = ViewModelProviders.of(this).get(GoalDetailViewModel::class.java)
        goalDetailViewModel.getGoalById(id).observe(this, Observer { goal ->
            val startTime = DateTime(goal!!.startDate)
            val endTime = DateTime(goal.endDate)
            val days = getDays(startTime, endTime)
            textViewDetailDescription.text = goal.description
            textViewDetailPriority.text = goal.priority
            textViewStartDate.text = getString(R.string.start_date_full, startTime.dayOfMonth().asText, startTime.monthOfYear().asText, startTime.year().asText)
            textViewEndDate.text = getString(R.string.end_date_full, endTime.dayOfMonth().asText, endTime.monthOfYear().asText, endTime.year().asText)
            textViewDaysLeft.text = getString(R.string.days_left, days)
        })
    }

    fun getDays(start_time: DateTime, end_time: DateTime): Long {
        val diffInMillis = end_time.millis - start_time.millis
        return diffInMillis / (60 * 60 * 24 * 1000)
    }

    private fun initializeViews() {
        textViewDetailDescription = findViewById(R.id.textview_detail_description)
        textViewDetailPriority = findViewById(R.id.textview_detail_priority)
        textViewStartDate = findViewById(R.id.textview_detail_startdate)
        textViewEndDate = findViewById(R.id.textview_detail_end_date)
        textViewDaysLeft = findViewById(R.id.textview_days_left)
    }
}