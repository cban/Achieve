package com.example.cbanda.achieve.presentation.list

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cbanda.achieve.R
import com.example.cbanda.achieve.models.db.Goal
import com.example.cbanda.achieve.presentation.detail.GoalDetailActivity
import com.example.cbanda.achieve.utilities.ViewModelFactory
import java.util.*


class GoalItemFragment : Fragment() {

    private lateinit var goalListViewModel: GoalListViewModel
    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var goalsAdapter: GoalsAdapter
    private lateinit var recyclerViewGoals: RecyclerView
    private lateinit var mLayoutManager: LinearLayoutManager

    private fun selectItemClicked(): CustomItemClickListener {
        return object : CustomItemClickListener {
            override fun onItemClick(v: View, position: Int) {
                Log.d(TAG, "clicked position:$position")
                val goal = v.tag as Goal
                val id = goal.id
                val name = goal.description
                val intent = Intent(activity, GoalDetailActivity::class.java)
                intent.putExtra("Goal", id)
                intent.putExtra("Description", name)

                startActivity(intent)
            }
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_goal, container, false)
        goalsAdapter = GoalsAdapter(ArrayList(), selectItemClicked(), requireContext())
        setupRecyclerView(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModels()
        getGoals()
    }

    private fun setupRecyclerView(view: View) {
        recyclerViewGoals = view.findViewById(R.id.recycler_view_goals)
        mLayoutManager = LinearLayoutManager(this.activity!!.baseContext)
        val decoration = DividerItemDecoration(recyclerViewGoals.context, mLayoutManager.orientation)
        recyclerViewGoals.addItemDecoration(decoration)
        recyclerViewGoals.layoutManager = mLayoutManager
        recyclerViewGoals.adapter = goalsAdapter


    }

    private fun setupViewModels() {
        goalListViewModel = ViewModelProviders.of(requireActivity()).get(GoalListViewModel::class.java)
    }
     private fun getGoals(){
        val goalsLiveDataObject = goalListViewModel.getGoals()
        goalsLiveDataObject.observe(this, Observer { goals -> goalsAdapter.setGoals(goals) })
    }

}
