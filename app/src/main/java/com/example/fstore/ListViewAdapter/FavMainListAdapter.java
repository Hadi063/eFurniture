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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.example.fstore.ConnectFlask;
import com.example.fstore.Data.Furniture;
import com.example.fstore.Data.TheStore;
import com.example.fstore.Fragments.homeFragments.home_product;
import com.example.fstore.Home;
import com.example.fstore.R;
import com.google.android.material.button.MaterialButton;

import org.json.JSONException;
import org.json.JSONObject;

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


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                ConnectFlask.getUrlProductFromID(TheStore.FAVORITES.get(position)),
                null,
                response -> {
                    ImageView img = v.findViewById(R.id.homeMainRecyclerImg);
                    MaterialButton add = v.findViewById(R.id.homeMainRecyclerAdd);
                    TextView name = v.findViewById(R.id.homeMainRecyclerName);
                    TextView price = v.findViewById(R.id.homeMainRecyclerPrice);
                    try {
                        Glide.with(v).load(response.get("image")).into((img));
                        name.setText(response.get("name").toString());
                        price.setText(response.get("price").toString());
                        add.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v1) {
                                //will do error --->
                                //Home.home.SwitchFragment(new home_product(position));
                            }
                        });

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                this::invalidResponse
        );
        ConnectFlask.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);
        return v;
    }


    private void invalidResponse(VolleyError error){}

    @Override
    public int getCount() {
        return TheStore.FAVORITES.size();
    }
}
