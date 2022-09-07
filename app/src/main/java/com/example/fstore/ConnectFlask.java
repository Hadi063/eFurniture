package com.example.fstore;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fstore.Fragments.signupFragments.signup;

import org.json.JSONArray;
import org.json.JSONObject;

public class ConnectFlask{


    public static final String URL = "http://192.168.1.108:5000";
    public static final String URL_LOGIN = URL + "/user";
    public static final String URL_CATEGORY = URL + "/category";
    public static final String URL_PRODUCT = URL_CATEGORY + "/product";
    public static final String URL_SEARCH = URL + "/search";
    public static final String URL_RANDOM = URL + "/random";
    public static final String URL_SIGNUP = URL + "/signup";

    private static ConnectFlask instance;

    public JSONObject login_response;
    public static JSONArray category_response;


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
    public void addToRequestQueue(StringRequest stringRequest){
        requestQueue.add(stringRequest);
    }
    private RequestQueue requestQueue;


    public static String getUrlLogin(String username,String password){

        return String.format(URL_LOGIN + "?username=%s&password=%s",username,password);
    }

    public static String getUrlCategory(String type){
        return String.format(URL_CATEGORY + "?type=%s",type);
    }

    public static String getUrlProductFromID(int id){
        return String.format(URL_PRODUCT + "?productid=%s",String.valueOf(id));
    }

    public static String getUrlSearch(String query){
        return String.format(URL_SEARCH + "?search=%s",query);
    }

    public static String getUrlRandom(){
        return String.format(URL_RANDOM);
    }
    public static String getUrlSignup(){
        return String.format(URL_SIGNUP + "?username=%s&password=%s&email=%s&first=%s&last=%s&country=%s&phone=%s",
                signup.username,signup.password,signup.email,signup.first,signup.last,signup.country,signup.phone);
    }
}
