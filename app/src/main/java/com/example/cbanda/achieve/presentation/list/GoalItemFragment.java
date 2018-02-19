package com.example.cbanda.achieve.presentation.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cbanda.achieve.R;
import com.example.cbanda.achieve.models.db.Goal;
import com.example.cbanda.achieve.presentation.detail.GoalDetailActivity;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class GoalItemFragment extends Fragment {


    private static final String ARG_COLUMN_COUNT = "column-count";

    private int mColumnCount = 1;
    GoalListViewModel goalListViewModel;
    GoalsAdapter goalsAdapter;
    RecyclerView recyclerViewGoals;
    LinearLayoutManager mLayoutManager;
    Goal goal;
    private List<Goal> goalList;

    public GoalItemFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        goalsAdapter = new GoalsAdapter(new ArrayList<Goal>(), SelectItemClicked());
        setupViewModels();
        //  changePriorityColor();

    }

    public customItemClickListener SelectItemClicked() {
        return new customItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Log.d(TAG, "clicked position:" + position);
                Goal goal = (Goal) v.getTag();
                int id = goal.getId();
                String name = goal.getDescription();
                Intent i = new Intent(getActivity(), GoalDetailActivity.class);
                i.putExtra("Goal", id);
                i.putExtra("Description", name);

                startActivity(i);
            }
        };
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_goal, container, false);
        setupRecyclerView(view);
        return view;
    }

    private void setupRecyclerView(View view) {
        recyclerViewGoals = view.findViewById(R.id.recycler_view_goals);
        mLayoutManager = new LinearLayoutManager(this.getActivity().getBaseContext());
        DividerItemDecoration decoration = new DividerItemDecoration(recyclerViewGoals.getContext(), mLayoutManager.getOrientation());
        recyclerViewGoals.addItemDecoration(decoration);
        recyclerViewGoals.setLayoutManager(mLayoutManager);
        recyclerViewGoals.setAdapter(goalsAdapter);


    }

    private void setupViewModels() {

        goalListViewModel = ViewModelProviders.of(getActivity()).get(GoalListViewModel.class);
        LiveData<List<Goal>> goalsLiveDataObject = goalListViewModel.getGoals();

        goalsLiveDataObject.observe(this, new Observer<List<Goal>>() {
            @Override
            public void onChanged(@Nullable List<Goal> goals) {

                goalsAdapter.setGoals(goals);

            }
        });
    }


    public void changePriorityColor() {
        LayerDrawable layerDrawable = (LayerDrawable) getResources()
                .getDrawable(R.drawable.rectangle_stroke);
        GradientDrawable gradientDrawable = (GradientDrawable) layerDrawable
                .findDrawableByLayerId(R.id.gradientDrawable);
        if (goal.getPriority().contains("medium")) {
            gradientDrawable.setColor(Color.GREEN);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
