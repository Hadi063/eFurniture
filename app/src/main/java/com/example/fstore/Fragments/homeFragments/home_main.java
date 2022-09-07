package com.example.fstore.Fragments.homeFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.fstore.ConnectFlask;
import com.example.fstore.Data.FurnitureType;
import com.example.fstore.R;
import com.example.fstore.RecyclerViewAdapters.HomeMainRecyclerViewAdapter;
import com.google.android.material.card.MaterialCardView;

import org.json.JSONArray;

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

        MaterialCardView chair = view.findViewById(R.id.homeMainCatChair);
        MaterialCardView bed = view.findViewById(R.id.homeMainCatBed);
        MaterialCardView couch = view.findViewById(R.id.homeMainCatCouch);
        MaterialCardView desk = view.findViewById(R.id.homeMainCatDesk);

        SearchView search = view.findViewById(R.id.homeMainSearchBar);

        recyclerView = view.findViewById(R.id.homeMainRecyclerView);
        GridLayoutManager glm = new GridLayoutManager(getContext(),2,GridLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(glm);

        chair.setOnClickListener(this::chairClick);
        bed.setOnClickListener(this::bedClick);
        couch.setOnClickListener(this::couchClick);
        desk.setOnClickListener(this::deskClick);

        search.clearFocus();
        search.setActivated(false);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                goSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        sendArrayRequest(ConnectFlask.getUrlRandom());

        homeMain = this;

    }

    private void goSearch(String query){
        sendArrayRequest(ConnectFlask.getUrlSearch(query));
    }

    private void chairClick(View v){
        sendArrayRequest(ConnectFlask.getUrlCategory(FurnitureType.Chair.name()));
    }

    private void bedClick(View v){
        sendArrayRequest(ConnectFlask.getUrlCategory(FurnitureType.Bed.name()));
    }
    private void couchClick(View v){
        sendArrayRequest(ConnectFlask.getUrlCategory(FurnitureType.Couch.name()));
    }

    private void deskClick(View v){
        sendArrayRequest(ConnectFlask.getUrlCategory(FurnitureType.Desk.name()));
    }
    private void validResponse(JSONArray response){
        ConnectFlask.category_response = response;
        recyclerView.setAdapter(new HomeMainRecyclerViewAdapter());
    }

    private void invalidResponse(VolleyError error){

    }

    private void sendArrayRequest(String URL){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                null,
                this::validResponse,
                this::invalidResponse
        );

        jsonArrayRequest.setRetryPolicy(
                new RetryPolicy() {
                    @Override
                    public int getCurrentTimeout() {
                        return 5000;
                    }
                    @Override
                    public int getCurrentRetryCount() {
                        return 5000;
                    }
                    @Override
                    public void retry(VolleyError error) throws VolleyError {
                    }
                }
        );

        ConnectFlask.getInstance(getContext()).addToRequestQueue(jsonArrayRequest);
    }


}
