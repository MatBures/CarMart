package CarMartServices;

import CarMart.Car;
import CarMart.CarMart;
import Security.SecurityCypher;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Method that is using BufferedWriter.
 * For loop that adds all car objects from listOfCars to carListToCypher. Then is called method from SecurityCypher named encryptCarMartData.
 * The method encrypts all car objects and separate each data by "," and writing to txt document.
 */
public class SaveCarsToTxtFileService {
    SecurityCypher security = new SecurityCypher();

    public void saveCarsToTxtFile(List<Car> listOfCars) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CarMart.txtFilePathWithOwnedCars))) {
            for (Car car : listOfCars) {
                List<Car> carListToCypher = new ArrayList<>();
                carListToCypher.add(car);
                String encryptedCarData = security.encryptCarMartData(carListToCypher);
                String[] encryptedDataSplit = encryptedCarData.split(",");
                for (String data : encryptedDataSplit) {
                    writer.write(data);
                    writer.write(",");
                }
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("Failed to save resources, please contact support.");
        }
    }
}