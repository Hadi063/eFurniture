package com.example.fstore.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.fstore.ConnectFlask;
import com.example.fstore.Main;
import com.example.fstore.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

public class login extends Fragment {


    private TextInputEditText username;
    private TextInputEditText password;
    private TextInputLayout usernameLayout;
    private TextInputLayout passwordLayout;

    private MaterialButton btn;

    private TextView signup;
    private TextView browse;
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
        usernameLayout = view.findViewById(R.id.loginUsernameLayout);
        passwordLayout = view.findViewById(R.id.loginPasswordLayout);
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

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                ConnectFlask.getUrlLogin(s1,s2),
                null,
                this::validLogin,
                this::noLoginResponse
        );

        jsonObjectRequest.setRetryPolicy(
                new RetryPolicy() {
                    @Override
                    public int getCurrentTimeout() {
                        return 5000;
                    }
                    @Override
                    public int getCurrentRetryCount() {
                        return 5000;
                    }
                    @Override
                    public void retry(VolleyError error) throws VolleyError {
                    }
                }
        );
        ConnectFlask.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);
        //Main.main.runSQL("LOGIN", s1 , s2);
    }

    public void validLogin(JSONObject response){
        System.out.println(response);
        try {
            String valid = response.getString("valid");
            if(valid.equals("true")){
                ConnectFlask.getInstance(getContext()).login_response = response;
                Main.main.goHome();
            }
            if(valid.equals("false")){
                invalidLogin();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void noLoginResponse(VolleyError error){
        Toast.makeText(getContext(),"Error connecting!",Toast.LENGTH_SHORT).show();
    }

    public void invalidLogin(){
        usernameLayout.setErrorEnabled(true);
        usernameLayout.setError("Invalid!");
        passwordLayout.setErrorEnabled(true);
        passwordLayout.setError("Invalid!");
    }


    private void SignUp(View v){

        Main.main.SwitchFragment(new signup());
        System.out.println("Sign UP!");
    }

    private void Browse(View v){
        System.out.println("BROWSE!");
    }
}
