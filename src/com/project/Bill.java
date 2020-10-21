package com.project;

import com.project.FastFood.FastFood;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class Bill extends Observable {
    private float total;

    private Map<String, Float> details;

    public Bill() {
        total = 0;
        details = new HashMap<>();
    }

    public void addToBill(FastFood food){
        this.total = this.getTotal() + food.getPrice();
        float price = food.getPrice();
        if (details.containsKey(food.toString())){
            price += details.get(food.toString());
        }
        details.put(food.toString(), price);
        setChanged();
        notifyObservers();
    }
    public float getTotal() {
        return this.total;
    }

    public Map<String, Float> getDetails() {
        return this.details;
    }
}
