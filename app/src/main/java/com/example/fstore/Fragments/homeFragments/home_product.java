package com.example.fstore.Fragments.homeFragments;

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

import com.example.fstore.Data.Furniture;
import com.example.fstore.Data.TheStore;
import com.example.fstore.R;

public class home_product extends Fragment {

    private int position;
    private Furniture f;
    public home_product(int position){
        this.position = position;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.__home_shop_product,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        f = TheStore.getFurniture(position);
        ImageView img = view.findViewById(R.id.homeShopProductImg);
        TextView name = view.findViewById(R.id.homeShopProductName);
        TextView price = view.findViewById(R.id.homeShopProductPrice);
        Button buy = view.findViewById(R.id.homeShopProductBuy);
        Button fav = view.findViewById(R.id.homeShopProductFav);

        img.setImageResource(f.imgID);
        name.setText(f.name);
        price.setText("" + f.price);

        fav.setOnClickListener(this::addToCart);

    }

    private void addToCart(View v){
        TheStore.CART.add(f);
    }
}
