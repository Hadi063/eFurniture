package com.example.fstore.Fragments.homeFragments;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.example.fstore.ConnectFlask;
import com.example.fstore.Data.Furniture;
import com.example.fstore.Data.TheStore;
import com.example.fstore.R;

import org.json.JSONException;
import org.json.JSONObject;

public class home_product extends Fragment {

    private int productID;

    private ImageView img;
    private TextView name;
    private TextView price;
    private Button buy;
    private Button fav;

    public home_product(String productID){
        this.productID = Integer.parseInt(productID);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.__home_shop_product,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        img = view.findViewById(R.id.homeShopProductImg);
        name = view.findViewById(R.id.homeShopProductName);
        price = view.findViewById(R.id.homeShopProductPrice);
        buy = view.findViewById(R.id.homeShopProductBuy);
        fav = view.findViewById(R.id.homeShopProductFav);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                ConnectFlask.getUrlProductFromID(productID),
                null,
                this::validResponse,
                this::invalidResponse
        );

        ConnectFlask.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

        fav.setOnClickListener(this::addToFavorites);
        buy.setOnClickListener(this::buyProduct);

    }

    private void validResponse(JSONObject response){
        try {
            Glide.with(this).load(response.get("image")).into(img);
            name.setText(response.get("name").toString());
            price.setText(response.get("price").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void invalidResponse(VolleyError error){}

    private void addToFavorites(View v){
        TheStore.FAVORITES.add(productID);
    }

    private void buyProduct(View v){


        try {
            String id = ConnectFlask.getInstance(getContext()).login_response.getString("id");
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.POST,
                    ConnectFlask.getUrlPostOrder(id, productID),
                    null,
                    this::buyValidResponse,
                    this::buyInvalidResponse
            );
            ConnectFlask.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void buyValidResponse(JSONObject response){}

    private void buyInvalidResponse(VolleyError error){}

}
