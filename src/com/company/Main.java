package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Main {

    private static Hero player1 = new Hero(new ArrayList<String>(), new ArrayList<>(), 0f,100,20, 10, new Location(new float[]{0f, 0f, 0f}), "Paladin", 2500),
            player2 = new Hero(new ArrayList<String>(), new ArrayList<>(), 0f,100,20, 10, new Location(new float[]{0f, 0f, 0f}), "Wizard", 2500);

    public static void main(String[] args) throws InterruptedException {

        while (true){
            TimeUnit.SECONDS.sleep(2);
            Random random = new Random();
            int r = random.nextInt(5);
            System.out.print("["+String.valueOf(r)+"]: ");
            switch(r){
                case 0:
                    player1.buy("someItem", 20);
                    System.out.println(player1.getInventory());
                    break;
                case 1:
                    player1.respawn(new Location(new float[]{2,4,6}));
                    break;
                case 2:
                    player1.attack(player2);
                    break;
                case 3:
                    player1.carry("someObject");
                    break;
                case 4:
                    player1.setDefence(true);
                    break;
                case 5:
                    player1.setDefence(false);
                    break;
            }
            r = random.nextInt(5);
            switch(r){
                case 0:
                    player2.buy("someItem", 20);
                    System.out.println(player2.getInventory());
                    break;
                case 1:
                    player2.respawn(new Location(new float[]{2,4,6}));
                    break;
                case 2:
                    player2.attack(player1);
                    break;
                case 3:
                    player2.carry("someObject");
                    break;
                case 4:
                    player2.setDefence(true);
                    break;
                case 5:
                    player2.setDefence(false);
                    break;
            }
            if (player1.getHealth() <= 0){
                System.out.println("Player 1 died...");
                break;
            }
            else if (player2.getHealth()<=0){
                System.out.println("Player 2 died");
                break;
            }
        }

    }
}
