package com.company;

import java.util.Random;

public class Location {
    private float x,y,z;

    public Location() {

    }

    public Location(float [] xyz) {
        this.x = xyz[0];
        this.y = xyz[1];
        this.z = xyz[2];

    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float[] getPosition(){
        return new float[]{x,y,z};
    }
}
