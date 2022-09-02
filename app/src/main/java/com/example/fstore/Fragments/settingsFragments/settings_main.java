package com.example.fstore.Fragments.settingsFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.example.fstore.ConnectFlask;
import com.example.fstore.R;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

public class settings_main extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.__settings_main,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        JSONObject jsonObject = ConnectFlask.getInstance(getContext()).login_response;

        androidx.fragment.app.FragmentManager fm = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        if(jsonObject != null){
            ImageView img = view.findViewById(R.id.settingsMenuImage);
            TextView name = view.findViewById(R.id.settingsMenuName);
            try {
                Glide.with(view).load(jsonObject.get("image")).into(img);
                name.setText(jsonObject.get("first").toString() + " " +jsonObject.get("last").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            fragmentTransaction.replace(R.id.settingsFrameLayout, new settings_online());
        }else{
            fragmentTransaction.replace(R.id.settingsFrameLayout, new settings_offline());
        }

        fragmentTransaction.commit();




    }
}
