package com.example.cbanda.achieve.presentation.add;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.cbanda.achieve.models.db.Goal;
import com.example.cbanda.achieve.models.repository.GoalRepository;
import com.example.cbanda.achieve.utilities.InjectorUtils;

import java.util.Date;


public class AddGoalViewModel extends AndroidViewModel {

    private GoalRepository goalRepository;
    private Date selectedStartDate;//look into joda time
    private Date selectedEndDate;
    private String prioritySelected;

    private String goalDescription;

    public AddGoalViewModel(@NonNull Application application) {
        super(application);
        goalRepository = InjectorUtils.getInstance(application);
    }

    public Date getSelectedStartDate() {
        return selectedStartDate;
    }

    public void setSelectedStartDate(Date selectedStartDate) {
        this.selectedStartDate = selectedStartDate;
    }

    public Date getSelectedEndDate() {
        return selectedEndDate;
    }

    public void setSelectedEndDate(Date selectedEndDate) {
        this.selectedEndDate = selectedEndDate;
    }

    public String getPrioritySelected() {
        return prioritySelected;
    }

    public void setPrioritySelected(String prioritySelected) {
        this.prioritySelected = prioritySelected;
    }

    public String getGoalDescription() {
        return goalDescription;
    }

    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
    }

    //  goalRepository.
    public void addGoal() {
        Goal goal = new Goal();
        goal.setPriority(getPrioritySelected());
        goal.setDescription(getGoalDescription());
        goal.setStartDate(getSelectedStartDate());
        goal.setEndDate(getSelectedEndDate());

        goalRepository.addGoal(goal);
    }
}
