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
import com.example.fstore.Data.FurnitureType;
import com.example.fstore.Data.TheStore;
import com.example.fstore.R;

import java.util.List;

public class HomeShopListAdapter extends ArrayAdapter {


    private int resource;
    private List<Furniture> f;


    public HomeShopListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.resource = resource;
        if(TheStore.type == null){
            f = TheStore.getAllFurniture();
        }else {
            f = TheStore.getFurnitureFromType(TheStore.type);
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(getContext()).inflate(resource,parent,false);

        ImageView img = v.findViewById(R.id.shopListImg);
        TextView name = v.findViewById(R.id.shopListName);
        TextView price = v.findViewById(R.id.shopListPrice);

        img.setImageResource(this.f.get(position).imgID);
        name.setText(this.f.get(position).name);
        price.setText("" + this.f.get(position).price);



        return v;
    }

    @Override
    public int getCount() {
        return f.size();
    }
}
