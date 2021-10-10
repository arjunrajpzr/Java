package com.arjun.design.patterns;

public class VehicleServiceMain {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();

        Vehicle vehicle = vehicleFactory.getInstance("BUS");
        vehicle.printDetails();
    }
}
