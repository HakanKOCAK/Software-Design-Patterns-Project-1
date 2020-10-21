package com.project;

import com.project.FastFood.FastFood;

import java.util.HashMap;
import java.util.Map;

public class Bill{
    private float total;

    private Map<String, Float> details;

    public Bill() {
        total = 0;
        details = new HashMap<>();
    }

    public void addToBill(FastFood food) throws InterruptedException{
        this.total = this.getTotal() + food.getPrice();
        details.put(food.toString(), food.getPrice());
    }
    public float getTotal() {
        return this.total;
    }

    public Map<String, Float> getDetails() {
        return this.details;
    }
}
