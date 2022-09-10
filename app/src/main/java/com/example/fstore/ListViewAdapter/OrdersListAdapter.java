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

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.bumptech.glide.Glide;
import com.example.fstore.ConnectFlask;
import com.example.fstore.R;
import com.example.fstore.RecyclerViewAdapters.HomeMainRecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OrdersListAdapter extends ArrayAdapter {


    private int resource;
    private String id;
    private JSONArray response;

    public OrdersListAdapter(@NonNull Context context, int resource, JSONArray response) {
        super(context, resource);
        this.resource = resource;
        this.response = response;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = LayoutInflater.from(getContext()).inflate(resource,parent,false);

        try {
            JSONObject object = response.getJSONObject(position);
            ImageView img = v.findViewById(R.id.orderImage);
            TextView name = v.findViewById(R.id.orderName);
            TextView price = v.findViewById(R.id.orderPrice);
            TextView brand = v.findViewById(R.id.orderBrand);
            TextView status = v.findViewById(R.id.orderStatus);
            Glide.with(v).load(object.get("image")).into(img);
            name.setText(object.get("name").toString());
            brand.setText(object.get("brand").toString());
            price.setText(object.get("price").toString());
            status.setText(object.get("status").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return v;
    }

    @Override
    public int getCount() {
        return response.length();
    }

}
