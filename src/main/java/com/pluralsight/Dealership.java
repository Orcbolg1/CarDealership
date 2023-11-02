package com.pluralsight;

import java.util.ArrayList;

public class Dealership {

    private String dealershipName;
    private String dealershipAddress;
    private String dealershipPhoneNumber;
    private ArrayList<Vehicle>inventory;

    public Dealership(String dealershipName, String dealershipAddress, String dealershipPhoneNumber) {
        this.dealershipName = dealershipName;
        this.dealershipAddress = dealershipAddress;
        this.dealershipPhoneNumber = dealershipPhoneNumber;
        this.inventory = new ArrayList<Vehicle>();
    }

    // Method to get vehicles within the specified price range.
    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max){
            ArrayList<Vehicle> inventoryWithinRange = new ArrayList<>();

        // Iterate through the inventory to find vehicles within the given price range
            for(Vehicle vehicle: inventory){
                if(vehicle.getPrice() >= min && vehicle.getPrice() <= max){
                    inventoryWithinRange.add(vehicle);
                }
            }
            return inventoryWithinRange;
        }

    // Method to get vehicles by make and model
    public ArrayList<Vehicle> getVehiclesByMakeAndModel(String make, String model) {
        ArrayList<Vehicle> vehiclesByMakeAndModel = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                vehiclesByMakeAndModel.add(vehicle);
            }
        }

        return vehiclesByMakeAndModel;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        // Method to retrieve vehicles by a specific year
        ArrayList<Vehicle> vehiclesByYear = new ArrayList<>();
        // Add logic here to filter vehicles by year
        return vehiclesByYear;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        // Method to retrieve vehicles by a specific color
        ArrayList<Vehicle> vehiclesByColor = new ArrayList<>();
        // Add logic here to filter vehicles by color
        return vehiclesByColor;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {
        // Method to retrieve vehicles within a specific mileage range
        ArrayList<Vehicle> vehiclesByMileage = new ArrayList<>();
        // Add logic here to filter vehicles by mileage range
        return vehiclesByMileage;
    }

    public ArrayList<Vehicle> getVehiclesByType(String type) {
        // Method to retrieve vehicles by a specific type
        ArrayList<Vehicle> vehiclesByType = new ArrayList<>();
        // Add logic here to filter vehicles by type
        return vehiclesByType;
    }

    public void removeVehicle(Vehicle vehicle) {
        // Method to remove a specific vehicle from the inventory
        // Add logic here to remove the provided vehicle from the inventory
    }
}

    // Adding a vehicle to the inventory
    public void addVehicle(Vehicle vehicle) {
        // Check if the vehicle is not null before adding it to the inventory
        if (vehicle != null) {
            inventory.add(vehicle);
            System.out.println("Vehicle added to the inventory: " + vehicle.getMake() + " " + vehicle.getModel());
        } else {
            System.out.println("Cannot add a null vehicle to the inventory.");
        }
    }

    //Method to return the whole inventory
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }


}
