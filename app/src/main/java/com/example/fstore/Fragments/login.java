package com.example.fstore.Fragments;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;

import com.example.fstore.Main;
import com.example.fstore.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class login extends Fragment {


    private TextInputEditText username;
    private TextInputEditText password;

    private MaterialButton btn;

    private TextView signup;
    private TextView browse;


    final Handler handler = new Handler();
    public GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,new int[] {0xFFFF9190,0xFF120C6E});
    public LinearLayout layout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.__login,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        username = view.findViewById(R.id.loginEditTextUser);
        password = view.findViewById(R.id.loginEditTextPassword);
        btn = view.findViewById(R.id.loginBtn);
        signup = view.findViewById(R.id.loginSignUp);
        browse = view.findViewById(R.id.loginBrowse);

        //layout = view.findViewById(R.id.loginMainLayout);
        //layout.setBackground(gd);


        btn.setOnClickListener(this::btnLogin);
        signup.setOnClickListener(this::SignUp);
        browse.setOnClickListener(this::Browse);

        //startLooper();

    }

    private void btnLogin(View v){
        String s1 = username.getText().toString();
        String s2 = password.getText().toString();

        Main.main.runSQL("LOGIN", s1 , s2);
    }

    public void startLooper(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after delay
                int[] i = gd.getColors();
                i[0] -= 10;
                i[1] -= 10;
                gd.setColors(i);
                layout.setBackground(gd);
                startLooper();
            }
        }, 1000);
    }

    private void SignUp(View v){

        Main.main.SwitchFragment(new signup());
        System.out.println("Sign UP!");
    }

    private void Browse(View v){
        System.out.println("BROWSE!");
    }
}
