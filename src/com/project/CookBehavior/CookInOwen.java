package com.project.CookBehavior;

import java.util.concurrent.TimeUnit;

public class CookInOwen extends CookBehavior {

    @Override
    public void cook(String food) throws InterruptedException {
        SetStatus("Your " + food + " is cooking in the owen");
        TimeUnit.SECONDS.sleep(1);
        SetStatus("Cooking is finished, your " + food + " is ready for packaging...");
        TimeUnit.SECONDS.sleep(1);
        SetStatus("Package is ready, enjoy your " + food + ".");
    }

    @Override
    public void display() {
        System.out.println("Cook in Owen");
    }

    @Override
    public String toString() {
        return "owen";
    }
}
