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
import java.sql.SQLException;

public class Main extends AppCompatActivity {

    public static Main main;

    private FrameLayout frame;
    private ConnectSQL sql;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        frame = findViewById(R.id.frameLayout);

        sql = new ConnectSQL();

        SwitchFragment(new login());

        main = this;
    }

    public void runSQL(String... s){
        goHome(null);
        //sql.execute(s);
    }

    public void SwitchFragment(Fragment f){
        androidx.fragment.app.FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, f);
        fragmentTransaction.commit();
    }

    public void goHome(ResultSet rs){

        startActivity(new Intent(this,Home.class));
        /*
        try {
            if(rs.isLast()){
                DataSingleton.getSignleton().first = rs.getString("first");
                DataSingleton.getSignleton().last = rs.getString("last");
                DataSingleton.getSignleton().phone = rs.getString("phone");
                startActivity(new Intent(this,Home.class));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

         */

    }

}
