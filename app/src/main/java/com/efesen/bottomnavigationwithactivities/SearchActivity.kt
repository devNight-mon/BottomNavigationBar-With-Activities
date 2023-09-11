package com.efesen.bottomnavigationwithactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class SearchActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        bindUIComponents()

        // Select Search Activity by default
        bottomNavigationView.selectedItemId = R.id.bottom_search

        handleTabButtonPress()
    }

    private fun bindUIComponents() {
        bottomNavigationView = findViewById(R.id.bottomNav)
    }
    private fun handleTabButtonPress() {
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_home -> {
                    loadActivities(MainActivity())
                    return@setOnItemSelectedListener true
                }

                R.id.bottom_search -> {
                    return@setOnItemSelectedListener true
                }

                R.id.bottom_cart -> {
                    loadActivities(ShoppingCartActivity())
                    return@setOnItemSelectedListener true
                }

                R.id.bottom_setting -> {
                    loadActivities(SettingActivity())
                    return@setOnItemSelectedListener true
                }
            }
            return@setOnItemSelectedListener false
        }
    }

    private fun loadActivities(activity: AppCompatActivity) {
        startActivity(Intent(applicationContext, activity::class.java))
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        finish()
    }
}