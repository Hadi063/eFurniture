package com.example.fstore.Fragments.settingsFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fstore.R;
import com.google.android.material.button.MaterialButton;

public class settings_online extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.__settings_main_online,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MaterialButton dark = view.findViewById(R.id.settingsOnlineDark);
        MaterialButton light = view.findViewById(R.id.settingsOnlineLight);
        MaterialButton logout = view.findViewById(R.id.settingsOnlineLogout);

        dark.setOnClickListener(this::darkClick);
        light.setOnClickListener(this::lightClick);
        logout.setOnClickListener(this::logoutClick);
    }

    private void darkClick(View v){}
    private void lightClick(View v){}
    private void logoutClick(View v){}
}
