package com.example.fstore;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import androidx.appcompat.content.res.AppCompatResources;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectFlask{


    public static final String URL = "http://192.168.1.108:5000";
    public static final String URL_LOGIN = URL + "/user";
    public static final String ULR_CATAGORY = URL + "/catagory";
    public static final String ULR_PRODUCT = ULR_CATAGORY + "/product";

    private static ConnectFlask instance;

    public JSONObject login_response;
    public static JSONArray catagory_response;


    public static ConnectFlask getInstance(Context context){
        if(instance == null)
            instance = new ConnectFlask(context);

        return instance;
    }

    public ConnectFlask(Context context){
        this.requestQueue = Volley.newRequestQueue(context);
    }

    public void addToRequestQueue(JsonObjectRequest jsonObjectRequest){
        requestQueue.add(jsonObjectRequest);
    }
    public void addToRequestQueue(JsonArrayRequest jsonArrayRequest){
        requestQueue.add(jsonArrayRequest);
    }

    private RequestQueue requestQueue;


    public static String getUrlLogin(String username,String password){

        return String.format(URL_LOGIN + "?username=%s&password=%s",username,password);
    }

    public static String getUlrCatagory(String type){
        return String.format(ULR_CATAGORY + "?type=%s",type);
    }

    public static String getUrlProductFromID(int id){
        return String.format(ULR_PRODUCT + "?productid=%s",String.valueOf(id));
    }
}
