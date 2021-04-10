package com.company;

import java.io.PrintStream;
import java.util.ArrayList;

public class Hero extends Beast {

    private PrintStream out = System.out;

    public Hero(ArrayList<String> inventory, ArrayList<String> abilities, float experience, float health, float damage, float speed, Location location, String type, int gold) {
        super(inventory, abilities, experience, health, damage, speed, location, type, gold);
    }


    public void buy(String itemName, int price){  // метод покупки объекта
        if (price > super.getGold()){
            out.println("Not enough gold!");
        }
        else{
            if (super.getInventory().size() < 64){
                ArrayList<String> newInventory = super.getInventory();
                newInventory.add(itemName);
                super.setInventory(newInventory);
                out.println("You got this: " + itemName);
                out.println("If you have enough money it is yours, my friend!\n*You got "+itemName+"*!");
                super.setGold(super.getGold() - price);
            } else{
                out.println("Your inventory is overflowed!");
            }

        }
    }

    public void carry(String objectToCarry){  // метод сбора объектов
        if (super.getInventory().size() < 64){
            ArrayList<String> newInventory = super.getInventory();
            newInventory.add(objectToCarry);
            super.setInventory(newInventory);
            out.println("You got this: " + objectToCarry);
        } else{
            out.println("Your inventory is overflowed!");
        }
    }

    public void respawn(Location location){
        super.setLocation(location);
        out.println("You respawned at " + location.toString());
    }


}
