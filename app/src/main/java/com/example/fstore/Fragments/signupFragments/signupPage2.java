package com.example.fstore.Fragments.signupFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.fstore.ConnectFlask;
import com.example.fstore.Fragments.login;
import com.example.fstore.Main;
import com.example.fstore.Maps;
import com.example.fstore.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;
import com.hbb20.CountryCodePicker;

public class signupPage2 extends Fragment {

    private TextInputEditText first;
    private TextInputEditText last;

    private MaterialButton back;
    private MaterialButton _signup;

    private TextInputEditText phone;
    private CountryCodePicker ccp;

    private MaterialCardView location;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.__signup_page2,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        _signup = view.findViewById(R.id.signupBtn);
        back = view.findViewById(R.id.signupBackPage2);
        first = view.findViewById(R.id.signupEditTextFirst);
        last = view.findViewById(R.id.signupEditTextLast);
        location = view.findViewById(R.id.signupLocation);

        phone = view.findViewById(R.id.signupEditTextPhone);
        ccp = view.findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(phone);

        back.setOnClickListener(this::goBack);
        _signup.setOnClickListener(this::goSignup);
        location.setOnClickListener(this::openMap);
    }

    private void goBack(View v){
        Main.main.SwitchFragment(new signupPage1());
    }
    private void goSignup(View v){
        //do quality checks ..
        signup.first = first.getText().toString();
        signup.last = last.getText().toString();
        signup.country = ccp.getDefaultCountryCodeWithPlus();
        signup.phone = ccp.getFormattedFullNumber();

        StringRequest request = new StringRequest(
                Request.Method.POST,
                ConnectFlask.getUrlSignup(),
                this::validResponse,
                this::onErrorResponse);

        ConnectFlask.getInstance(getContext()).addToRequestQueue(request);
    }

    private void validResponse(String response){

        Main.main.SwitchFragment(new login());
        System.out.println(response);
    }

    public void onErrorResponse(VolleyError error) {

    }


    private void openMap(View v){
        getActivity().startActivity(new Intent(getContext(), Maps.class));
    }
}
