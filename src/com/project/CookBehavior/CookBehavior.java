package com.project.CookBehavior;

public abstract class CookBehavior {
    String status = "Awaiting";

    public abstract void cook(String food) throws InterruptedException;
    public abstract void display();
    public abstract String toString();

    public void SetStatus(String status)
    {
        this.status = status;
    }
    public String GetStatus(){
        return status;
    }
}
