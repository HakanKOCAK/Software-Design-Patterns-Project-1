package com.project;


import com.project.FastFood.FastFood;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class User implements Observer {
    private List<FastFood> order;
    private Bill bill;

    public User(){
        order = new ArrayList<>();
        bill = new Bill();
    }

    public void addFood(FastFood food) throws InterruptedException {
        this.order.add(food);
        this.getBill().addToBill(food);
    }

    public List<FastFood> getFood(){
        return this.order;
    }

    public Bill getBill(){
        return this.bill;
    }

    @Override
    public void update(Observable o, Object arg) {
        Bill observer = (Bill) o;
        System.out.println("Total Payment: " + observer.getTotal() + "$");
    }
}