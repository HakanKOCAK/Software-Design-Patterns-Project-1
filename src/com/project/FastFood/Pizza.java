package com.project.FastFood;

public class Pizza extends FastFood{

    public Pizza(){
       price = (float) 15.99;
    }

    @Override
    public float getPrice() {
        return this.price;
    }

    @Override
    public void display() {
        System.out.println("Who doesn't like a delicious Pizza");
    }


    @Override
    public String toString() {
        return "pizza";
    }
}
