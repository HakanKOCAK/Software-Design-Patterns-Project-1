package com.project.FastFood;

import com.project.CookBehavior.CookBehavior;
import com.project.CookBehavior.CookInOwen;
import com.project.CookBehavior.CookInPan;

import java.util.List;
import java.util.Observable;

public class Pizza extends FastFood{

    public Pizza(){
       price = (float) 15.99;
        possibleCookingTypes.add(new CookInOwen());
        possibleCookingTypes.add(new CookInPan());
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
    public void performCook() throws InterruptedException{
        getCookBehavior().cook(toString());
    }

    @Override
    public void setCookBehavior(CookBehavior cb) {
        this.cookingBehavior = cb;
        this.cookingBehavior.addObserver(this);
    }

    @Override
    public CookBehavior getCookBehavior() {
        return this.cookingBehavior;
    }

    @Override
    public List<CookBehavior> getPossibleCookingTypes() {
        return possibleCookingTypes;
    }

    @Override
    public void update(Observable o, Object arg) {
        CookBehavior observer = (CookBehavior) o;
        System.out.println(observer.getStatus());
    }

    @Override
    public String toString() {
        return "pizza";
    }
}
