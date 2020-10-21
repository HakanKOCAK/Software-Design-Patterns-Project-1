package com.project.FastFood;

public class Hamburger extends FastFood {

    public Hamburger(){
        price = (float) 10.50;
    }

    @Override
    public float getPrice() {
        return this.price;
    }


    @Override
    public void display() {
        System.out.println("Going to be the best hamburger you've ever had");
    }

    @Override
    public String toString() {
        return "hamburger";
    }
}
