package com.arjun.others;

public class SchoolGroundSingleton {

    private static SchoolGroundSingleton schoolGroundInstance=null;

    private final int area=100;
    private boolean isBooked;
    private SchoolGroundSingleton(){
    }

    public SchoolGroundSingleton getInstance(){
        if(schoolGroundInstance==null) {
            schoolGroundInstance = new SchoolGroundSingleton();
        }
        return schoolGroundInstance;
    }

    public int getArea() {
        return area;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
