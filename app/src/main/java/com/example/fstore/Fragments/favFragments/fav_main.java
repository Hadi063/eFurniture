package com.example.fstore.Fragments.favFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fstore.ListViewAdapter.FavMainListAdapter;
import com.example.fstore.R;

public class fav_main extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.__fav_main,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        ListView list = view.findViewById(R.id.favMainListView);
        list.setAdapter(new FavMainListAdapter(getContext(),R.layout.__home_main_recycler));
    }

    private void buyClick(View v){

    }
}
