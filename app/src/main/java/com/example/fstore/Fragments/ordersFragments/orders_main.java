package com.example.fstore.Fragments.ordersFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.fstore.ConnectFlask;
import com.example.fstore.ListViewAdapter.OrdersListAdapter;
import com.example.fstore.R;

import org.json.JSONArray;
import org.json.JSONException;

public class orders_main extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.__location_main,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {
            String id = ConnectFlask.getInstance(getContext()).login_response.getString("id");
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                    Request.Method.GET,
                    ConnectFlask.getUrlGetOrders(id),
                    null,
                    this::validResponse,
                    this::invalidResponse
            );

            ConnectFlask.getInstance(getContext()).addToRequestQueue(jsonArrayRequest);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void validResponse(JSONArray response){

        ListView list = getView().findViewById(R.id.searchMainListView);
        list.setAdapter(new OrdersListAdapter(getContext(),R.layout.__orders_list_adapter,response));
    }

    private void invalidResponse(VolleyError error){

    }
}
