package com.example.fstore.Data;

import java.util.ArrayList;
import java.util.List;

public class FurnitureStore {

    public List<Furniture> f;
    public FurnitureType type;

    public FurnitureStore(FurnitureType type){
        this.f = new ArrayList<>();
        this.type = type;

    }

}
