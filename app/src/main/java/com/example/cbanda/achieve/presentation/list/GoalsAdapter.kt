package com.example.cbanda.achieve.presentation.list

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.cbanda.achieve.R
import com.example.cbanda.achieve.models.db.Goal


class GoalsAdapter(private var goals: List<Goal>?, private var customItemClickListener: CustomItemClickListener, private var context: Context) : RecyclerView.Adapter<GoalsAdapter.GoalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_goal, parent, false)
        val goalViewHolder = GoalViewHolder(view)
        view.setOnClickListener { v -> customItemClickListener.onItemClick(v, goalViewHolder.position) }
        return goalViewHolder
    }

    override fun onBindViewHolder(holder: GoalViewHolder, position: Int) {

            val layerDrawable = ContextCompat.getDrawable(context,R.drawable.rectangle_stroke) as LayerDrawable
            val gradientDrawable = layerDrawable.findDrawableByLayerId(R.id.gradientDrawable) as GradientDrawable
        if (goals != null) {
            val goal = goals!![position]
            when {
                goal.priority.equals(HIGH, ignoreCase = true) -> gradientDrawable.setColor(Color.RED)
                goal.priority.equals(MEDIUM, ignoreCase = true) -> gradientDrawable.setColor(Color.YELLOW)
                goal.priority.equals(LOW, ignoreCase = true) -> gradientDrawable.setColor(Color.GREEN)
            }
            holder.itemView.tag = goal
            holder.goalTextView.text = goal.description
            holder.priorityTextView.text = goal.priority


        } else {
            // Covers the case of data not being ready yet.
            holder.goalTextView.text = BLANK
            holder.priorityTextView.text = BLANK
        }

    }

    override fun getItemCount(): Int {
        return goals?.size ?: 0
    }

    fun setGoals(goals: List<Goal>) {
        this.goals = goals
        notifyDataSetChanged()
    }

    inner class GoalViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var goalTextView: TextView = view.findViewById<View>(R.id.descriptionTextView) as TextView
        var priorityTextView: TextView = view.findViewById<View>(R.id.priorityTextView) as TextView

    }

    companion object {
        const val MEDIUM = "Medium"
        const val HIGH = "High"
        const val LOW = "Low"
        const val BLANK = "Nothing"
    }
}
