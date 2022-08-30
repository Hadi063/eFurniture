package com.example.fstore;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.fstore.Data.TheStore;
import com.example.fstore.Fragments.favFragments.fav_main;
import com.example.fstore.Fragments.homeFragments.home_main;
import com.example.fstore.Fragments.locationFragments.location_main;
import com.example.fstore.Fragments.settingsFragments.settings_main;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    public static Home home;

    private BottomNavigationView nav;
    private FrameLayout frame;

    private int selectedNavItem;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        TheStore.setTheShop();

        nav = findViewById(R.id.homeBottomNavigationView);
        frame = findViewById(R.id.homeFrameLayout);

        nav.setItemIconTintList(null);
        nav.setOnItemSelectedListener(this::navItemSelected);

        selectedNavItem = R.id.homeMenuHome;

        SwitchFragment(new home_main());

        home = this;
    }

    private boolean navItemSelected(MenuItem item){


        if(item.getItemId() == R.id.homeMenuHome){
            SwitchFragment(new home_main());
            return true;
        }
        if(item.getItemId() == R.id.homeMenuLove){
            SwitchFragment(new fav_main());
            return true;
        }
        if(item.getItemId() == R.id.homeMenuLocation){
            //SwitchFragment(new location_main());
            return true;
        }

        if(item.getItemId() == R.id.homeMenuSettings){
            SwitchFragment(new settings_main());
            return true;
        }

        return true;
    }

    public void SwitchFragment(Fragment f){
        androidx.fragment.app.FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.homeFrameLayout, f);
        fragmentTransaction.commit();
    }
}
