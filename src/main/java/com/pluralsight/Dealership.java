package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    // Properties of the Dealership Class
    private String dealershipName;
    private String dealershipAddress;
    private String dealershipPhoneNumber;
    private ArrayList<Vehicle>inventory;

    // Constructor to initialize a Dealership object
    public Dealership(String dealershipName, String dealershipAddress, String dealershipPhoneNumber) {
        this.dealershipName = dealershipName;
        this.dealershipAddress = dealershipAddress;
        this.dealershipPhoneNumber = dealershipPhoneNumber;
        this.inventory = new ArrayList<Vehicle>();
    }

    // Getters and setters for the Dealership properties
    public String getDealershipName() {
        return dealershipName;
    }

    public void setDealershipName(String dealershipName) {
        this.dealershipName = dealershipName;
    }

    public String getDealershipAddress() {
        return dealershipAddress;
    }

    public void setDealershipAddress(String dealershipAddress) {
        this.dealershipAddress = dealershipAddress;
    }

    public String getDealershipPhoneNumber() {
        return dealershipPhoneNumber;
    }

    public void setDealershipPhoneNumber(String dealershipPhoneNumber) {
        this.dealershipPhoneNumber = dealershipPhoneNumber;
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }

    // Method to get vehicles within the specified price range.
    public List<Vehicle> getVehiclesByPrice(double min, double max){
            List<Vehicle> inventoryWithinRange = new ArrayList<>();

        // Iterate through the inventory to find vehicles within the given price range
            for(Vehicle vehicle: inventory){
                if(vehicle.getPrice() >= min && vehicle.getPrice() <= max){
                    inventoryWithinRange.add(vehicle);
                }
            }
            return inventoryWithinRange;
        }

    // Method to get vehicles by make and model
    public List<Vehicle> getVehiclesByMakeAndModel(String make, String model) {
        List<Vehicle> vehiclesByMakeAndModel = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                vehiclesByMakeAndModel.add(vehicle);
            }
        }

        return vehiclesByMakeAndModel;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        // Method to retrieve vehicles by a specific year
        List<Vehicle> vehiclesByYear = new ArrayList<>();
        // Add logic here to filter vehicles by year
        return vehiclesByYear;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        // Method to retrieve vehicles by a specific color
        List<Vehicle> vehiclesByColor = new ArrayList<>();
        // Add logic here to filter vehicles by color
        return vehiclesByColor;
    }

    public List<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {
        // Method to retrieve vehicles within a specific mileage range
        List<Vehicle> vehiclesByMileage = new ArrayList<>();
        // Add logic here to filter vehicles by mileage range
        return vehiclesByMileage;
    }

    public List<Vehicle> getVehiclesByType(String type) {
        // Method to retrieve vehicles by a specific type
        List<Vehicle> vehiclesByType = new ArrayList<>();
        // Add logic here to filter vehicles by type
        return vehiclesByType;
    }

    public void removeVehicle(Vehicle vehicle) {
        // Method to remove a specific vehicle from the inventory
        // Add logic here to remove the provided vehicle from the inventory
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
    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public List<Vehicle> getInventory() {
        return inventory;
    }
}
