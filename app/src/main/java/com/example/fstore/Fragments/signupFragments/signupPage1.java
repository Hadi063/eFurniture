package com.example.fstore.Fragments.signupFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.fstore.Fragments.login;
import com.example.fstore.Main;
import com.example.fstore.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;

public class signupPage1 extends Fragment {
    private TextInputEditText username;
    private TextInputEditText password;
    private TextInputEditText email;
    private MaterialButton _continue;

    private MaterialButton back;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.__signup_page1,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        username = view.findViewById(R.id.signupEditTextUser);
        password = view.findViewById(R.id.signupEditTextPassword);
        email = view.findViewById(R.id.signupEditTextEmail);

        _continue = view.findViewById(R.id.signupContinueBtn);
        back = view.findViewById(R.id.signupBackPage1);

        _continue.setOnClickListener(this::goContinue);
        back.setOnClickListener(this::goBack);
    }


    private void goContinue(View v){
        signup.username = username.getText().toString();
        signup.password = username.getText().toString();
        signup.email = email.getText().toString();

        Main.main.SwitchFragment(new signupPage2());
    }

    private void goBack(View v){
        Main.main.SwitchFragment(new login());
    }
}
