package com.project.CookBehavior;

import java.util.Observable;

public abstract class CookBehavior extends Observable {
    String status = "Awaiting";

    public abstract void cook(String food) throws InterruptedException;
    public abstract void display();
    public abstract String toString();

    public void SetStatus(String status)
    {
        this.status = status;
        setChanged();
        notifyObservers();
    }
    public String GetStatus(){
        return status;
    }
}
