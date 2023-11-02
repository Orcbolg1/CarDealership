package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {

    public Dealership getDealership(String filePath) {
        Dealership dealership = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean skipHeader = true; // Flag to skip the header line

            while ((line = reader.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue; // Skip the header line
                }

                String[] data = line.split(","); // Assuming CSV is comma-separated

                int vin = Integer.parseInt(data[0]);
                int year = Integer.parseInt(data[1]);
                String make = data[2];
                String model = data[3];
                String color = data[4];
                int odometer = Integer.parseInt(data[5]);
                double price = Double.parseDouble(data[6]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, color, odometer, price);

                if (dealership == null) {
                    dealership = new Dealership("Example Dealership", "123 Example St", "123-456-7890");
                }

                dealership.addVehicle(vehicle);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the CSV file: " + e.getMessage());
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership, String filePath) {
        // Implement logic to save dealership information and inventory to the CSV file
        // Use BufferedWriter or FileWriter to write data to the specified file path

        // Write the header line containing column names (if necessary)
        // Write each vehicle's details to the CSV file in the appropriate format
        // You might use a loop to iterate through the vehicles in the dealership's inventory

        // Provide error handling if any exceptions occur during file writing
    }
}