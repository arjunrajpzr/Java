package com.arjun.design.patterns;

public class VehicleFactory {

    public Vehicle getInstance(String vehicleName) {
        if (vehicleName == null || vehicleName.isEmpty()) {
            return null;
        }
        if ("CAR".equals(vehicleName)) {
            return new Car();
        }
        if ("BUS".equals(vehicleName)) {
            return new Bus();
        }
        if ("JEEP".equals(vehicleName)) {
            return new Jeep();
        }
        return null;
    }
}
