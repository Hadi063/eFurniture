package com.example.fstore;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.fstore.Fragments.login;

import java.sql.ResultSet;

public class Main extends AppCompatActivity {

    public static Main main;

    private FrameLayout frame;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        frame = findViewById(R.id.frameLayout);

        SwitchFragment(new login());

        main = this;
    }

    public void SwitchFragment(Fragment f){
        androidx.fragment.app.FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, f);
        fragmentTransaction.commit();
    }

    public void goHome(){

        startActivity(new Intent(this,Home.class));

    }

}
