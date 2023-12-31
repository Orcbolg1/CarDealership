package com.pluralsight;
import java.io.*;

public class DealershipFileManager {

         // Method to read a CSV file and populate a Dealership object
        public Dealership getDealership(String filePath) {
            // Initialize an empty Dealership
            Dealership dealership = new Dealership("", "","");

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                int lineNumber = 1;

                while ((line = br.readLine()) != null) {
                    // Split each line using the '|' delimiter
                    String[] parts = line.split("\\|");
                    if (lineNumber == 1) {
                        // If it's the first line (usually for Dealership details)
                        // Extract and set the Dealership name, address, and phone number
                        String name = parts[0];                         // dealership name
                        dealership.setDealershipName(name);
                        String address = parts[1];                      //dealership address
                        dealership.setDealershipAddress(address);
                        String phoneNumber = parts[2];                  // dealership phone number
                        dealership.setDealershipPhoneNumber(phoneNumber);
                    } else {
                        // If it's a line for a vehicle, parse the details and create a Vehicle object
                        String[] data = line.split("\\|");
                        int vin = Integer.parseInt(data[0]);    // vin
                        int year = Integer.parseInt(data[1]);   // year
                        String make = data[2];                  // make
                        String model = data[3];                 // model
                        String type = data[4];                  // type
                        String color = data[5];                 // color
                        int odometer = Integer.parseInt(data[6]);   // odometer
                        double price = Double.parseDouble(data[7]); // price

                        // Create a Vehicle object and add it to the Dealership's inventory
                        Vehicle vehicle = new Vehicle(vin, year, make, model,type, color, odometer, price);

                        dealership.addVehicle(vehicle);
                    }
                    lineNumber++;
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading the CSV file: " + e.getMessage());
            }

            return dealership;
        }

        public void saveDealership(Dealership dealership) {
            // Implement logic to save dealership information and inventory to the CSV file
            // Use BufferedWriter or FileWriter to write parts to the specified file path

            // Write the header line containing column names (if necessary)
            // Write each vehicle's details to the CSV file in the appropriate format
            // You might use a loop to iterate through the vehicles in the dealership's inventory

            // Provide error handling if any exceptions occur during file writing
            try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("dealership.csv"));
            //save dealership info
            bufferedWriter.write(dealership.toString()+"\n");

            //save all the vehicles
            for (Vehicle vehicle : dealership.getInventory()) {
                bufferedWriter.write(vehicle.toString()+"\n");
            }
            bufferedWriter.close(); //flushes the buffer

            } catch (IOException e) {
            throw new RuntimeException(e);
            }
        }
}

