package com.example.fstore;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectSQL extends AsyncTask<String, Void, ResultSet> {


    private final String url = "jdbc:mysql://192.168.48.12:3306/menu";
    private final String username = "root";
    private final String password = "root";

    private String code = "";

    private Statement st;

    @Override
    protected ResultSet doInBackground(String... strings) {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            st = con.createStatement();
            code = strings[0];

            if(code.equals("__LOGIN")){
                return st.executeQuery(String.format("select first,last,phone from users where username = '%s' and password = '%s' LIMITE(1);",strings[1],strings[2]));
            }
            if(code.equals("")){}


        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    protected void onPostExecute(ResultSet result) {
        try {
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        if(code.equals("__LOGIN")){
            Main.main.goHome(result);
        }

        System.out.println("Post execute results: " + result);;
    }
}
