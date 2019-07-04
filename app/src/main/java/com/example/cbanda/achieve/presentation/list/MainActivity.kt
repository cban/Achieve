package com.example.cbanda.achieve.presentation.list

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.cbanda.achieve.R
import com.example.cbanda.achieve.presentation.add.AddGoalActivity
import com.example.cbanda.achieve.presentation.inspiration.InspirationFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), InspirationFragment.OnFragmentInteractionListener {

    private var mSectionsPagerAdapter: TabSectionPageAdapter? = null

    private lateinit var mViewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = TabSectionPageAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        setUpViewPager()

        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, AddGoalActivity::class.java)
            startActivity(intent)
        }

    }

    private fun setUpViewPager() {

        view_pager.adapter = mSectionsPagerAdapter
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(view_pager))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun onFragmentInteraction(uri: Uri) {

    }
}
