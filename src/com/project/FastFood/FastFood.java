package com.project.FastFood;

import com.project.CookBehavior.CookBehavior;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public abstract class FastFood implements Observer {
    protected CookBehavior cookingBehavior;
    protected float price = 0;
    protected List<CookBehavior> possibleCookingTypes = new ArrayList<>();

    public abstract void performCook() throws InterruptedException;
    public abstract void setCookBehavior(CookBehavior cb);
    public abstract CookBehavior getCookBehavior();
    public abstract List<CookBehavior> getPossibleCookingTypes();
    public abstract float getPrice();
    public abstract void display();
    public abstract String toString();
}
