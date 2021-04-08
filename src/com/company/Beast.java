package com.company;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Beast {

    private PrintStream out = System.out;

    private ArrayList<Integer> inventory = new ArrayList<>(64), abilities = new ArrayList<>(3);
    private float experience, health, startHealth, damage, speed;
    private Location location;
    private String type;
    private int gold;

    public void setDefence(boolean defence) {
        this.defence = defence;
    }

    public boolean isDefence() {
        return defence;
    }

    private boolean defence = false;

    public Beast(ArrayList<Integer> inventory, ArrayList<Integer> abilities, float experience, float health, float damage, float speed, Location location, String type, int gold) {
        this.inventory = inventory;
        this.abilities = abilities;
        this.experience = experience;
        this.health = health;
        this.startHealth = health;
        this.damage = damage;
        this.speed = speed;
        this.location = location;
        this.type = type;
        this.gold = gold;
    }

    public void setInventory(ArrayList<Integer> inventory) {
        this.inventory = inventory;
    }

    public void setAbilities(ArrayList<Integer> abilities) {
        this.abilities = abilities;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public ArrayList<Integer> getInventory() {
        return inventory;
    }

    public ArrayList<Integer> getAbilities() {
        return abilities;
    }

    public float getExperience() {
        return experience;
    }

    public float getHealth() {
        return health;
    }

    public float getDamage() {
        return damage;
    }

    public float getSpeed() {
        return speed;
    }

    public Location getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public int getGold() {
        return gold;
    }

    public float getStartHealth() {
        return startHealth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beast beast = (Beast) o;
        return Float.compare(beast.experience, experience) == 0 && Float.compare(beast.health, health) == 0 && Float.compare(beast.startHealth, startHealth) == 0 && Float.compare(beast.damage, damage) == 0 && Float.compare(beast.speed, speed) == 0 && gold == beast.gold && defence == beast.defence && Objects.equals(out, beast.out) && Objects.equals(inventory, beast.inventory) && Objects.equals(abilities, beast.abilities) && Objects.equals(location, beast.location) && Objects.equals(type, beast.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(out, inventory, abilities, experience, health, startHealth, damage, speed, location, type, gold, defence);
    }

    public void attack(Beast beast){
        if (!beast.isDefence()){
            if (beast.getHealth() - damage > 0){
                beast.setHealth(beast.getHealth() - damage);
                out.println("You damaged " + type + ", its health for now: "+ String.valueOf(beast.getHealth()/beast.getStartHealth() * 100));
                if (!defence){
                    out.println("OUCH! It damaged you! Your health for now: " + (health/startHealth * 100));
                }
            }
            else {
                beast.die();
                beast = null;
            }
        }
    }

    public void die(){
        out.println(type + "died... Press F to Pay Respects...");
    }

    public void move(Location nextLocation){
        /*
        TODO: дописать нормальную реализацию передвижения тварей
         */
        location = nextLocation;
    }

}
