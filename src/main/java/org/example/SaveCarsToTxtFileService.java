package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import static org.example.CarMart.txtFilePathWithOwnedCars;

/**
 * Method that is using BufferedWriter.
 * For loop that goes through list for each car object and writer will write every car's parameter separated with ","
 * by using get methods from Class Car.
 */
public class SaveCarsToTxtFileService {
    public void saveCarsToTxtFile(List<Car> listOfCars) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(txtFilePathWithOwnedCars))) {
            for (Car car : listOfCars) {
                writer.write(car.getId() + ", " + car.getBrand() + ", " + car.getType() + ", " + car.getAge() + ", " + car.getPrice() + ", " + car.getKm());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("Failed to save resources, please contact support.");
        }
    }
}
