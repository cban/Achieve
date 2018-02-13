package com.example.cbanda.achieve.presentation.list;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cbanda.achieve.R;
import com.example.cbanda.achieve.models.db.Goal;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * <p>
 * interface.
 */
public class GoalItemFragment extends Fragment {


    private static final String ARG_COLUMN_COUNT = "column-count";

    private int mColumnCount = 1;
    GoalListViewModel goalListViewModel;
    GoalsAdapter goalsAdapter;
    RecyclerView recyclerViewGoals;
    RecyclerView.LayoutManager mLayoutManager;

    public GoalItemFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        goalsAdapter = new GoalsAdapter(null);

        setupViewModels();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_goal, container, false);

        recyclerViewGoals = view.findViewById(R.id.recycler_view_goals);
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerViewGoals.setLayoutManager(mLayoutManager);
        recyclerViewGoals.setAdapter(goalsAdapter);


        return view;
    }

    private void setupViewModels() {

        goalListViewModel = ViewModelProviders.of(getActivity()).get(GoalListViewModel.class);
        goalListViewModel.getGoals().observe(this, new Observer<List<Goal>>() {
            @Override
            public void onChanged(@Nullable List<Goal> goals) {
                goalsAdapter.setGoals(goals);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}
