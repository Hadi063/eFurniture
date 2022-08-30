package com.example.fstore.Fragments.homeFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fstore.Data.FurnitureType;
import com.example.fstore.Data.TheStore;
import com.example.fstore.R;

public class home_catagory extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.__home_catagory,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayout chair = view.findViewById(R.id.catagoryChair);
        LinearLayout couch = view.findViewById(R.id.catagoryCouch);
        LinearLayout bed = view.findViewById(R.id.catagoryBed);

        chair.setOnClickListener(this::chairClick);
        couch.setOnClickListener(this::couchClick);
        bed.setOnClickListener(this::bedClick);
    }

    private void chairClick(View v){
        TheStore.type = FurnitureType.Chair;
    }

    private void couchClick(View v){
        TheStore.type = FurnitureType.Couch;
    }

    private void bedClick(View v){
        TheStore.type = FurnitureType.Bed;
    }
}
