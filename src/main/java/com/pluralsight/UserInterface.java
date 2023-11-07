package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    // Constructor to initialize and display the user interface
    public UserInterface() {

    }

    // Method to handle the main display and interaction with the user
    public void display() {
        init(); // Initialize the dealership


        boolean running = true;
        // Creating a loop for user interaction
        while (running) {
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
                    running = false;
                    break;
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
        System.out.println("==========[ Price Search ]==========");
        System.out.println("Enter Minimum Price: ");
        double min = scanner.nextDouble();
        System.out.println("Enter Maximum Price: ");
        double max = scanner.nextDouble();
        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    public void processGetByVehiclesByMakeModelRequest() {
        System.out.println("==========[ Make and Model ]==========");
        System.out.println("Enter Make: ");
        String make = scanner.nextLine();
        System.out.println("Enter Model: ");
        String model = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByMakeAndModel(make, model));
    }

    public void processGetByVehiclesByYearRequest() {
        System.out.println("==========[ Year Search ]==========");
        System.out.println("Enter Minimum Year: ");
        int min = scanner.nextInt();
        System.out.println("Enter Maximum Year");
        int max = scanner.nextInt();
        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    public void processGetByVehiclesByColorRequest() {
        System.out.println("==========[ Color Search ]==========");
        System.out.println("Enter Color: ");
        String color = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByColor(color));
    }

    public void processGetByVehiclesByMileageRequest() {
        System.out.println("==========[ Mileage Search ]==========");
        System.out.println("Enter Minimum Mileage: ");
        int min = scanner.nextInt();
        System.out.println("Enter Maximum Mileage");
        int max = scanner.nextInt();
        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    public void processGetByVehiclesTypeRequest() {
        System.out.println("==========[ Type Search ]==========");
        System.out.println("Enter Type of Vehicles: ");
        String type = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByType(type));
    }

    public void ProcessRemoveVehicleRequest() {
        System.out.println("==========[ Remove Vehicle ]==========");
        System.out.println("Enter Vehicle Vin: ");
        int vin = scanner.nextInt();

        System.out.println("Removing...");
        List<Vehicle> vehicles = dealership.getVehiclesByVin(vin);
        displayVehicles(vehicles);

        if (vehicles.size() > 0) dealership.removeVehicle(vehicles.get(0));
        else return; //if empty do nothing return

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(this.dealership);

    }

    public void processAddVehicleRequest() {
        System.out.println("==========[ Add Vehicle ]==========");
        System.out.println("Enter Vehicle Vin (5-digit): ");
        int vin = scanner.nextInt();

        System.out.println("Enter Vehicle Year: ");
        int year = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Enter Vehicle Make: ");
        String make = scanner.nextLine();

        System.out.println("Enter Vehicle Model: ");
        String model = scanner.nextLine();

        System.out.println("Enter Vehicle Type: ");
        String vehicleType = scanner.nextLine();

        System.out.println("Enter Vehicle Color: ");
        String color = scanner.nextLine();

        scanner.nextLine();

        System.out.println("Enter Vehicle Mileage: ");
        int odometer = scanner.nextInt();

        System.out.println("Enter Vehicle Price: ");
        double price = scanner.nextDouble();

        dealership.addVehicle(new Vehicle(
                vin, year, make, model, vehicleType, color, odometer, price
        ));
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(this.dealership);

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
