package com.arjun.design.patterns;

public class SchoolGroundSingleton {

    private static SchoolGroundSingleton schoolGroundInstance=null;

    private final int area=100;
    private boolean isBooked;
    private String bookedClassName="Not Booked";
    private SchoolGroundSingleton(){
    }

    public SchoolGroundSingleton getInstance(){
        if(schoolGroundInstance==null)
            schoolGroundInstance=new SchoolGroundSingleton();
        return schoolGroundInstance;
    }

    public int getArea() {
        return area;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public String getBookedClassName(){
        return bookedClassName;
    }
    public void releaseGround(){
        this.isBooked = false;
        this.bookedClassName="Not Booked";
    }

    public void bookGround(String bookedClassName) {
        this.isBooked = true;
        this.bookedClassName=bookedClassName;
    }
}
