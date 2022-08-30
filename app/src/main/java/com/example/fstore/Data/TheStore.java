package com.example.fstore.Data;

import com.example.fstore.R;

import java.util.ArrayList;
import java.util.List;

public class TheStore {

    public static List<FurnitureStore> F;
    public static List<Furniture> CART;

    public static FurnitureType type = null;

    public static List<Furniture> getFurnitureFromType(FurnitureType type){

        for(int i = 0; i < F.size();i++){
            if(F.get(i).type == type){
                return F.get(i).f;
            }
        }

        return F.get(0).f;
    }

    public static List<Furniture> getAllFurniture(){

        List<Furniture> f = new ArrayList<>();
        for (int i = 0; i < F.size(); i++) {
            f.addAll(F.get(i).f);
        }

        return f;
    }

    public static Furniture getFurniture(int position){
        if(TheStore.type == null){
            return getAllFurniture().get(position);
        }else{
            for (int i = 0; i < F.size(); i++) {
                if(F.get(i).type == type){
                    return F.get(i).f.get(position);
                }
            }
        }

        return F.get(0).f.get(0);
    }

    public static void setTheShop(){

        F = new ArrayList<>();
        CART = new ArrayList<>();
        for (FurnitureType type: FurnitureType.values()) {
            F.add(new FurnitureStore(type));
        }

        AddToTheShop(new Furniture(FurnitureType.Chair,"Chair","Something to sit on!",20, R.drawable.chair1));
        AddToTheShop(new Furniture(FurnitureType.Bed,"Bed","An area on sleep on!",20, R.drawable.bed1));
        AddToTheShop(new Furniture(FurnitureType.Couch,"Couch","A space to chill on!",20, R.drawable.couch1));

    }

    public static void AddToTheShop(Furniture f){

        for(int i = 0; i < F.size();i++){
            if(F.get(i).type == f.type){
                F.get(i).f.add(f);
                return;
            }
        }



    }

}
