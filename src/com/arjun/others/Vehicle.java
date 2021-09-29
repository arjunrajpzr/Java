package com.arjun.others;

public class Vehicle {
    private Vehicle vehicleInstance;

    private Vehicle(){
    }

    public synchronized Vehicle getVehicleInstance(){
        if(vehicleInstance==null){
            vehicleInstance=new Vehicle();
        }
        return vehicleInstance;
    }
}
