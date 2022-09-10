package com.example.fstore.RecyclerViewAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.example.fstore.ConnectFlask;
import com.example.fstore.Data.TheStore;
import com.example.fstore.Fragments.homeFragments.home_product;
import com.example.fstore.Home;
import com.example.fstore.R;
import com.google.android.material.button.MaterialButton;

import org.json.JSONException;
import org.json.JSONObject;

public class FavRecyclerAdapter extends RecyclerView.Adapter<FavRecyclerAdapter.ViewHolder>{

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView img;
        private final MaterialButton add;
        private final TextView name;
        private final TextView price;

        public ViewHolder(View view) {
            super(view);
            img = view.findViewById(R.id.homeMainRecyclerImg);
            add = view.findViewById(R.id.homeMainRecyclerAdd);
            name = view.findViewById(R.id.homeMainRecyclerName);
            price = view.findViewById(R.id.homeMainRecyclerPrice);
        }

        public ImageView getImg(){
            return img;
        }
        public MaterialButton getAdd(){
            return add;
        }
        public TextView getName() {
            return name;
        }
        public TextView getPrice() {
            return price;
        }
    }

    public FavRecyclerAdapter() {
        //f = TheStore.getFurnitureFromUrlResponse();
        //f = TheStore.F;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public FavRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.__home_main_recycler, null);

        return new FavRecyclerAdapter.ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(FavRecyclerAdapter.ViewHolder viewHolder, final int position) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                ConnectFlask.getUrlProductFromID(TheStore.FAVORITES.get(position)),
                null,
                response -> {
                    try {
                        Glide.with(viewHolder.itemView).load(response.get("image")).into((viewHolder.getImg()));
                        viewHolder.getName().setText(response.get("name").toString());
                        viewHolder.getPrice().setText(response.get("price").toString());
                        viewHolder.getAdd().setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v1) {
                                //will do error --->
                                try {
                                    Home.home.SwitchFragment(new home_product(response.get("id").toString()));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {}
        );
        ConnectFlask.getInstance(viewHolder.itemView.getContext()).addToRequestQueue(jsonObjectRequest);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return TheStore.FAVORITES.size();
    }
}
