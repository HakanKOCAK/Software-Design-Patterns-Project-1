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
        int choice;
        int i;
        User user = new User();
        FastFood food;

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
            else if(choice < 4){
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

                List<CookBehavior> possibleCookingTypes = food.getPossibleCookingTypes();

                for(i=0; i<possibleCookingTypes.toArray().length; i++){
                    System.out.format("%s ", i+1);
                    possibleCookingTypes.get(i).display();
                }

                int cookBehavior;
                cookBehavior = sc.nextInt();
                while (cookBehavior < 1 || cookBehavior > possibleCookingTypes.toArray().length){
                    System.out.println("\nHow would you like your "+food.toString()+" to be cooked");
                    cookBehavior = sc.nextInt();
                }
                food.setCookBehavior(possibleCookingTypes.get(cookBehavior-1));
                System.out.format("%s %s", "Your "+food.toString(), "will be cooked in/on the " + food.getCookBehavior().toString()+"\n");
                user.addFood(food);

                System.out.println("\nDo you want anything else?");
                System.out.println("0 Exit");
                System.out.println("1 Pizza");
                System.out.println("2 Hamburger");
                System.out.println("3 Fries\n");
            } else {
                System.out.println("What would you like to eat? (1, 2, 3)");
            }

        } while (choice > 0);


        if(user.getFood().toArray().length > 0){
            System.out.println("\nOrder Details\n-------------------\n");
            Map<String, Float> details = user.getBill().getDetails();

            float pizzaPrice = new Pizza().getPrice();
            float hamburgerPrice = new Hamburger().getPrice();
            float friesPrice = new Fries().getPrice();
            for(Map.Entry<String, Float> entry: details.entrySet()){
                float price;
                if (entry.getKey().equalsIgnoreCase("pizza")){
                    price = pizzaPrice;
                } else if (entry.getKey().equalsIgnoreCase("fries")){
                    price = friesPrice;
                } else {
                    price = hamburgerPrice;
                }
                int count = (int) (entry.getValue()/price);
                System.out.format("%s: %.2f$ (%d)\n", entry.getKey(), entry.getValue(), count);
            }
            System.out.println("\nTotal Payment: " +user.getBill().getTotal() +"$");
            System.out.println("\n--------------------------\n");
            for(FastFood f: user.getFood()){
                f.performCook();
            }
        }

        System.out.println("\nSee you again!!!\n");
    }
}
