package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import static org.example.CarMart.txtFilePathWithOwnedCars;

/**
 * Method that is using BufferedReader. While there is a line in txt document, the reader will put each field in txt document and make new car object.
 * First field [0] is for car's id, second field [1] is for car's brand and so on.
 * Then the new car object carToAddToTxtFile is added to listOfCars.
 */
public class LoadCarsFromTxtFileService {
    public boolean ableToLoadAllCarsFromTxtFile = true;

    public void loadCarsFromTxtFile(List<Car> listOfCars) {
        try (BufferedReader reader = new BufferedReader(new FileReader(txtFilePathWithOwnedCars))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(", ");
                int id = Integer.parseInt(fields[0]);
                String brand = fields[1];
                String type = fields[2];
                int age = Integer.parseInt(fields[3]);
                int price = Integer.parseInt(fields[4]);
                int km = Integer.parseInt(fields[5]);
                Car carToAddToTxtFile = new Car(id, brand, type, age, price, km);
                listOfCars.add(carToAddToTxtFile);
            }

        } catch (Exception e) {
            ableToLoadAllCarsFromTxtFile = false;
            System.out.println("Failed to load resources, please contact support.");
        }
    }
}
