package com.example.fstore.Fragments.homeFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fstore.Data.FurnitureType;
import com.example.fstore.ListViewAdapter.HomeShopListAdapter;
import com.example.fstore.R;

public class home_shop extends Fragment {

    private FurnitureType type;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.__home_shop,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        ListView list = view.findViewById(R.id.homeShopListView);
        list.setAdapter(new HomeShopListAdapter(getContext(),R.layout.__home_shop_list));
        list.setOnItemClickListener(this::onItemClick);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //home_main.homeMain.SwitchFragment(new home_product(position));
    }
}
