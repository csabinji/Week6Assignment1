package com.sabin.softuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sabin.softuser.adapter.ViewPageAdapter
import com.sabin.softuser.fragment.AddFragment
import com.sabin.softuser.fragment.DisplayFragment
import com.sabin.softuser.fragment.WebFragment
import com.sabin.softuser.model.User
import com.sabin.softuser.model.userList

class MainActivity : AppCompatActivity() {

    private lateinit var lstTitle : ArrayList<String>
    private lateinit var lstFragments : ArrayList<Fragment>
    private lateinit var tabs : TabLayout
    private lateinit var viewPager : ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabs = findViewById(R.id.tabs)
        viewPager = findViewById(R.id.viewPager)

        populateList()
        loadUser()

        val adapter = ViewPageAdapter(lstFragments,supportFragmentManager,lifecycle)
        viewPager.adapter = adapter
        TabLayoutMediator(tabs,viewPager) {tab, position ->
            tab.text = lstTitle[position]

            if(lstTitle[position] == "Home"){
                tab.setIcon(R.drawable.home)
            }else if(lstTitle[position] == "Add Student"){
                tab.setIcon(R.drawable.addst)
            }else{
                tab.setIcon(R.drawable.about)
            }
        }.attach()
    }

    private fun populateList(){
        lstTitle = ArrayList<String>()
        lstTitle.add("Home")
        lstTitle.add("Add Student")
        lstTitle.add("About Us")

        lstFragments = ArrayList<Fragment>()
        lstFragments.add(DisplayFragment())
        lstFragments.add(AddFragment())
        lstFragments.add(WebFragment())

    }

    private fun loadUser(){
        userList.addUser(User("Anmol KC",27,"Male","Kathmandu",
                "https://www.biofamous.com/wp-content/uploads/Anmol-KC.jpg"))

        userList.addUser(User("Bhanubhakta",21,"Male","Gulmi",
                        "https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fspecials-images.forbesimg.com%2Fdam%2Fimageserve%2F968210608%2F960x0.jpg"))

        userList.addUser(User("Unish Bhattarai",21,"Male","Kathmandu",
                "https://media1.popsugar-assets.com/files/thumbor/MzvXHf8nPs7dDMpZcmuyXxFWrVk/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2019/01/08/691/n/1922398/d00b278d5c34c37b4aebd5.04082562_/i/Actors-You-Thought-Were-American.jpg")
        )
    }
}