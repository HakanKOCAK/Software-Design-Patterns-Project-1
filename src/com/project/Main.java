package com.project;

import com.project.CookBehavior.CookBehavior;
import com.project.FastFood.FastFood;
import com.project.FastFood.Fries;
import com.project.FastFood.Hamburger;
import com.project.FastFood.Pizza;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int choice = 0;
        int i = 0;
        User user = new User();
        FastFood food;
        user.getBill().addObserver(user);

        System.out.println("Welcome to the FastFood Store!\n---------------------------------\n");
        System.out.println("0 Exit");
        System.out.println("1 Pizza");
        System.out.println("2 Hamburger");
        System.out.println("3 Fries\n");
        System.out.println("What would you like to eat? ");
        do {
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            if(choice == 0) break;

            while (choice < 1 || choice > 3){
                System.out.format("%s ","What would you like to eat?(1, 2 or 3)");
                choice = sc.nextInt();
            }

            if (choice == 1){
                food = new Pizza();
            } else if (choice == 2){
                food = new Hamburger();
            } else {
                food = new Fries();
            }

            System.out.format("%s ","Nice choice!!!");
            food.display();
            System.out.println("\nHow would you like your "+food.toString()+" to be cooked");

            List<CookBehavior> cbList = food.getCookBehaviors();
            i = 0;
            for(i=0; i<cbList.toArray().length; i++){
                System.out.format("%s ", i+1);
                cbList.get(i).display();
            }

            int cookBehavior = 0;
            cookBehavior = sc.nextInt();
            while (cookBehavior < 1 || cookBehavior > cbList.toArray().length){
                System.out.println("\nHow would you like your "+food.toString()+" to be cooked");
                cookBehavior = sc.nextInt();
            }
            food.setCookBehavior(cbList.get(cookBehavior-1));
            System.out.format("%s %s", "Your "+food.toString(), "will be cooked in/on the " + food.getCookBehavior().toString()+"\n");
            food.getCookBehavior().addObserver(food);
            user.addFood(food);

            System.out.println("\nDo you want anything else?");
            System.out.println("0 Exit");
            System.out.println("1 Pizza");
            System.out.println("2 Hamburger");
            System.out.println("3 Fries\n");

        } while (choice > 0 && choice < 4);


        if(user.getFood().toArray().length > 0){
            System.out.println("\nOrder Details\n-------------------\n");
            Map<String, Float> details = user.getBill().getDetails();
            for(Map.Entry<String, Float> entry: details.entrySet()){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("Total Payment: " +user.getBill().getTotal());
            System.out.println("\n--------------------------\n");
            for(FastFood f: user.getFood()){
                f.performCook();
            }
        }

        System.out.println("\nSee you again!!!\n");
    }
}
