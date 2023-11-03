package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;


    // Constructor to initialize and display the user interface
    public UserInterface() {
        // Initialization in the constructor
        display();
    }

    // Method to handle the main display and interaction with the user
    public void display() {
        init(); // Initialize the dealership

        // Creating a loop for user interaction
        while (true) {
            displayMenu(); // Display the menu options
            int userCommand = readUserCommand(); // Read user input

            switch (userCommand) {
                // Case statements for different functionalities
                case 1:
                    processGetByVehiclesByPriceRequest();
                    break;
                case 2:
                    processGetByVehiclesByMakeModelRequest();
                    break;
                case 3:
                    processGetByVehiclesByYearRequest();
                    break;
                case 4:
                    processGetByVehiclesByColorRequest();
                    break;
                case 5:
                    processGetByVehiclesByMileageRequest();
                    break;
                case 6:
                    processGetByVehiclesTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    ProcessRemoveVehicleRequest();
                    break;
                case 99:
                    System.out.println("Exiting the Dealership Interface. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
    }

    // Method to display the menu options
    private void displayMenu() {
        // Display menu options for user interaction
        // Display different options for the user
        System.out.println("----- Main Menu -----");
        System.out.println("1. Search vehicles by price range");
        System.out.println("2. Search vehicles by make and model");
        System.out.println("3. Search vehicles by year");
        System.out.println("4. Search vehicles by color");
        System.out.println("5. Search vehicles by mileage range");
        System.out.println("6. Search vehicles by type");
        System.out.println("7. Display all vehicles");
        System.out.println("8. Add a vehicle");
        System.out.println("9. Remove a vehicle");
        System.out.println("99. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to read the user's command
    private int readUserCommand() {
        // Simulated user input for demonstration (you might use Scanner or other means to get user input)
        Scanner scanner = new Scanner(System.in);
        int UserCommand = scanner.nextInt();
        return UserCommand;
    }

    // Method to initialize the Dealership
    private void init() {
        // Create an instance of DealershipFileManager, read the CSV file, and assign the dealership
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealership = dealershipFileManager.getDealership("dealership.csv");
    }


    // Empty methods for different functionalities
    public void processGetByVehiclesByPriceRequest() {
        // Method for searching vehicles by price range
        // Implement as needed
    }

    public void processGetByVehiclesByMakeModelRequest() {
        // Method for searching vehicles by make and model
        // Implement as needed
    }

    public void processGetByVehiclesByYearRequest() {
        // Method for searching vehicles by year
        // Implement as needed
    }

    public void processGetByVehiclesByColorRequest() {
        // Method for searching vehicles by color
        // Implement as needed
    }

    public void processGetByVehiclesByMileageRequest() {
        // Method for searching vehicles by mileage range
        // Implement as needed
    }

    public void processGetByVehiclesTypeRequest() {
        // Method for searching vehicles by type
        // Implement as needed
    }

    public void ProcessRemoveVehicleRequest() {
        // Method for calling the removing a vehicle method

    }

    public void processAddVehicleRequest() {
        // Method for to call adding a vehicle method

    }

    public void processGetAllVehiclesRequest() {
        // Method for displaying all vehicles
        System.out.println("All Vehicles in the Dealership:");
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            System.out.println(vehicle);
        }
    }
    // Method to display a list of vehicles
    private void displayVehicles(List<Vehicle> listOfVehicles){
        // Loop through the list of vehicles and display their details
        for (Vehicle vehicles: listOfVehicles ) {
            System.out.println(vehicles);
        }
    }
}
