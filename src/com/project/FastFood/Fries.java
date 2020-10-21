package com.project.FastFood;

import com.project.CookBehavior.CookBehavior;
import com.project.CookBehavior.CookInFryer;
import com.project.CookBehavior.CookInOwen;
import com.project.CookBehavior.CookInPan;

import java.util.List;
import java.util.Observable;

public class Fries extends FastFood {

    public Fries(){
        price = (float) 4.50;
        cbList.add(new CookInOwen());
        cbList.add(new CookInPan());
        cbList.add(new CookInFryer());
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
    public void performCook() throws InterruptedException {
        getCookBehavior().cook(toString());
    }

    @Override
    public void setCookBehavior(CookBehavior cb) {
        this.cb=cb;
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
        return "fries";
    }
}
