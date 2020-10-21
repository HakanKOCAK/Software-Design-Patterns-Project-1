package com.project.FastFood;

public class Fries extends FastFood {

    public Fries(){
        price = (float) 4.50;
    }

    @Override
    public float getPrice() {
        return this.price;
    }

    @Override
    public void display() {
        System.out.println("Ready to taste our fries made with fresh potatoes??");
    }

    @Override
    public String toString() {
        return "fries";
    }
}
