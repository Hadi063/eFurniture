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
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fstore.Data.FurnitureType;
import com.example.fstore.Data.TheStore;
import com.example.fstore.R;
import com.example.fstore.RecyclerViewAdapters.HomeMainRecyclerViewAdapter;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class home_main extends Fragment {

    public static home_main homeMain;

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.__home_main,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //LinearLayout shop = view.findViewById(R.id.homeShop);
        //LinearLayout catagory = view.findViewById(R.id.homeCatagory);

        MaterialButton chair = view.findViewById(R.id.homeMainCatChair);
        MaterialButton bed = view.findViewById(R.id.homeMainCatBed);

        TextInputEditText search = view.findViewById(R.id.homeMainSearchBar);

        recyclerView = view.findViewById(R.id.homeMainRecyclerView);

        chair.setOnClickListener(this::chairClick);
        bed.setOnClickListener(this::bedClick);

        homeMain = this;

    }



    private void chairClick(View v){
        TheStore.type = FurnitureType.Chair;
        recyclerView.setAdapter(new HomeMainRecyclerViewAdapter(FurnitureType.Chair));
    }

    private void couchClick(View v){
        TheStore.type = FurnitureType.Couch;
        recyclerView.setAdapter(new HomeMainRecyclerViewAdapter(FurnitureType.Couch));
    }

    private void bedClick(View v){
        TheStore.type = FurnitureType.Bed;
        recyclerView.setAdapter(new HomeMainRecyclerViewAdapter(FurnitureType.Bed));
    }
}
