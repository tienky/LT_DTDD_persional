package com.example.cuoiky_bt;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;
    View fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        fragment = findViewById(R.id.fragment);

        bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment fragment = new fragment_featured();;
            if(item.getItemId() == R.id.feat){
                fragment = new fragment_featured();
            } else if (item.getItemId() == R.id.feed) {
                fragment = new fragment_feed();
            }else if (item.getItemId() == R.id.settings) {
                fragment = new fragment_setting();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
            return true;
        });
    }
}