package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    Vehicle vehicle = new Vehicle(99999, 2023,"Toyota", "Tacoma", "Truck", "White", 10, 70000);

    @Test
    public void testingCarVin() {
        assertEquals(99999, vehicle.getVin());
    }

    @Test
    public void testingCarYear() {
        assertEquals(2023, vehicle.getYear());
    }

    @Test
    public void testingCarMake() {
        assertEquals("Toyota", vehicle.getMake());
    }

    @Test
    public void testingCarModel() {
        assertEquals("Tacoma", vehicle.getModel());
    }

    @Test
    public void testingCarType() {
        assertEquals("Truck", vehicle.getType());
    }

    @Test
    public void testingCarColor() {
        assertEquals("White", vehicle.getColor());
    }

    @Test
    public void testingCarOdometer() {
        assertEquals(10, vehicle.getOdometer());
    }

    @Test
    public void testingCarPrice() {
        assertEquals(70000, vehicle.getPrice());
    }
}