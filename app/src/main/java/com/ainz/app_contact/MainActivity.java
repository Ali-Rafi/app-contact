package com.ainz.app_contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        NavController navController  = Navigation.findNavController(this, R.id.fragment);
        BottomNavigationView navView = findViewById(R.id.bottomNavigationView);
        NavigationUI.setupWithNavController(navView, navController);
    }
}