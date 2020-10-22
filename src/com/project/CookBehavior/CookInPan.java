package com.project.CookBehavior;

import java.util.concurrent.TimeUnit;

public class CookInPan extends CookBehavior {
    @Override
    public void cook(String food) throws InterruptedException {
        setStatus("Your " + food + " is cooking in the pan");
        TimeUnit.SECONDS.sleep(1);
        setStatus("Cooking is finished, your " + food + " is ready for packaging...");
        TimeUnit.SECONDS.sleep(1);
        setStatus("Package is ready, enjoy your " + food + ".");
    }

    @Override
    public void display() {
        System.out.println("Cook in Pan");
    }

    @Override
    public String toString() {
        return "pan";
    }
}
