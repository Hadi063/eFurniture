package com.example.fstore.ListViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.fstore.Data.Furniture;
import com.example.fstore.Data.TheStore;
import com.example.fstore.Fragments.homeFragments.home_product;
import com.example.fstore.Home;
import com.example.fstore.R;
import com.google.android.material.button.MaterialButton;

public class FavMainListAdapter extends ArrayAdapter {

    private int resource;

    public FavMainListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.resource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = LayoutInflater.from(getContext()).inflate(resource,parent,false);

        ImageView img = v.findViewById(R.id.homeMainRecyclerImg);
        MaterialButton add = v.findViewById(R.id.homeMainRecyclerAdd);
        TextView name = v.findViewById(R.id.homeMainRecyclerName);
        TextView price = v.findViewById(R.id.homeMainRecyclerPrice);

        Furniture f = TheStore.CART.get(position);

        img.setImageResource(f.imgID);
        name.setText(f.name);
        price.setText("" + f.price);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //will do error --->
                //Home.home.SwitchFragment(new home_product(position));
            }
        });

        return v;
    }

    @Override
    public int getCount() {
        return TheStore.CART.size();
    }
}
