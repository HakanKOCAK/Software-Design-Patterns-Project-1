package com.project.FastFood;

import com.project.CookBehavior.CookBehavior;
import com.project.CookBehavior.CookInPan;
import com.project.CookBehavior.CookOnGrill;

import java.util.List;
import java.util.Observable;

public class Hamburger extends FastFood {

    public Hamburger(){
        price = (float) 10.50;
        cbList.add(new CookOnGrill());
        cbList.add(new CookInPan());
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
    public void performCook() throws InterruptedException{
        getCookBehavior().cook(toString());
    }

    @Override
    public void setCookBehavior(CookBehavior cb) {
        this.cb = cb;
    }

    @Override
    public CookBehavior getCookBehavior() {
        return this.cb;
    }

    @Override
    public List<CookBehavior> getCookBehaviors() {
        return this.cbList;
    }

    @Override
    public void update(Observable o, Object arg) {
        CookBehavior observer = (CookBehavior) o;
        System.out.println(observer.GetStatus());
    }

    @Override
    public String toString() {
        return "hamburger";
    }
}
