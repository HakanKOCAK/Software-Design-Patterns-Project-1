package com.project.CookBehavior;

import java.util.Observable;

public abstract class CookBehavior extends Observable {
    protected String status = "Awaiting";

    public abstract void cook(String food) throws InterruptedException;
    public abstract void display();
    public abstract String toString();

    public void setStatus(String status)
    {
        this.status = status;
        setChanged();
        notifyObservers();
    }
    public String getStatus(){
        return status;
    }
}
