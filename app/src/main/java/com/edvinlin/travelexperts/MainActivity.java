package com.edvinlin.travelexperts;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/*
 * Author: Edvin Lin
 * Date: October 2020
 * Purpose: Threaded Project Part 3
 * Description: Android Application that consumes a RESTful API using Retrofit2;
 * Designed based on the class exercise Travel Experts
 * Application allows for user to Log In with Agent Credentials (Not Implemented)
 * Add/Update/Delete Customers, Travel Packages and Bookings.
 * Built with Fragments and SharedViewModels
 * Cat Fact API added in place of a Live Chatting Application
 * */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up Bottom nav
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_chat, R.id.navigation_dashboard, R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        //  Hide Action Bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

}