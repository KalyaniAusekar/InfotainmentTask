package com.example.infotainmenttask

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.chaquo.python.Python
import com.example.infotainmenttask.fragments.ActivityFragment
import com.example.infotainmenttask.fragments.FoodFragment
import com.example.infotainmenttask.fragments.TrendingFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cardview_design.*
import kotlinx.android.synthetic.main.scrollview_buttons_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //hide status bar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

            // hide bottom navigation
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        setContentView(R.layout.activity_main)
        setSupportActionBar(myToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)


        val trendingFragment = TrendingFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment,trendingFragment)
        transaction.addToBackStack(null)
        transaction.commit()


        btn_trending.setOnClickListener{

            val trendingFragment = TrendingFragment()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment,trendingFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        btn_food?.setOnClickListener {

                val foodFragment = FoodFragment()
                val manager = supportFragmentManager
                val transaction = manager.beginTransaction()
                transaction.replace(R.id.fragment,foodFragment)
                transaction.addToBackStack(null)
                transaction.commit()
        }

        btn_activity.setOnClickListener {

            val activityFragment = ActivityFragment()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment,activityFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        /*btn_activity.setOnClickListener {

            val activityFragment = ActivityFragment()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment,activityFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }*/
    }


    override fun onBackPressed() {
        super.onBackPressed()
        this.finishAffinity()

    }

    override fun onDestroy() {
        super.onDestroy()
        this.finishAffinity()
    }
}