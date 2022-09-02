package com.example.fstore.Data;

import com.example.fstore.ConnectFlask;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TheStore {

    public static List<Furniture> F;
    public static List<Integer> FAVORITES;

    public static FurnitureType type = null;

    public static List<Furniture> getFurnitureFromUrlResponse(){

        List<Furniture> f = new ArrayList<>();

        for (int i = 0; i < ConnectFlask.category_response.length(); i++) {
            try {
                JSONObject jsonObject = ConnectFlask.category_response.getJSONObject(i);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return f;
    }
    public static void setTheShop(){
        F = new ArrayList<>();
        FAVORITES = new ArrayList<>();
    }
}
