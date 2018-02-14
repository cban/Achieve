package com.example.cbanda.achieve.presentation.list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class TabSectionPageAdapter extends FragmentPagerAdapter {

    public TabSectionPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new GoalItemFragment();
        } else if (position == 1) {
            return new InspirationFragment();
        } else return null;
    }


    @Override
    public int getCount() {
        return 2;
    }
}




