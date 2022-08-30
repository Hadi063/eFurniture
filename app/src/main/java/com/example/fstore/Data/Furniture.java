package com.example.fstore.Data;

public class Furniture {


    public static int CURRENT_ID = 0;

    public FurnitureType type;
    public String name;
    public String description;
    public double price;
    public int id;
    public int imgID;

    public Furniture(FurnitureType type, String name,String des, double price, int imgID){
        this.type = type;
        this.name = name;
        this.description = des;
        this.price = price;
        this.imgID = imgID;
        this.id = CURRENT_ID;
        CURRENT_ID++;
    }
}
