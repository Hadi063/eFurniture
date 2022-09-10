package com.example.fstore.Fragments.settingsFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fstore.ConnectFlask;
import com.example.fstore.Main;
import com.example.fstore.R;
import com.google.android.material.button.MaterialButton;

public class settings_offline extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.__settings_main_offline,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MaterialButton btn = view.findViewById(R.id.settingsOfflineBtn);
        btn.setOnClickListener(this::btnClick);
    }


    private void btnClick(View v){
        ConnectFlask.getInstance(getContext()).login_response = null;
        getActivity().startActivity(new Intent(getContext(), Main.class));
    }
}
