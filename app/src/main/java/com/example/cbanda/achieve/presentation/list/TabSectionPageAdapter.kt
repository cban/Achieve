package com.example.cbanda.achieve.presentation.list

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

import com.example.cbanda.achieve.presentation.inspiration.InspirationFragment


class TabSectionPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {

        return when (position) {
            0 -> GoalItemFragment()
            1 -> InspirationFragment()
            else -> null
        }
    }


    override fun getCount(): Int {
        return 2
    }
}




