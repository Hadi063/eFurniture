package com.example.fstore;

public class DataSingleton {

    private static DataSingleton ds;

    public static DataSingleton getSignleton(){
        if(ds == null){
            ds = new DataSingleton();
        }

        return ds;
    }

    public String first = "Ata";
    public String last = "Daddy";
    public String phone = "0598765432";
}
