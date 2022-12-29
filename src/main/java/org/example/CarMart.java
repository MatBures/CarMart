package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CarMart class has many methods for running the program successfully.
 * addingCarsToList;
 * showCarsInCarMart;
 * sellCarToCarMart;
 * buyCarFromCartMart;
 * validateIntegerInput;
 */
public class CarMart {
    private Scanner scanner = new Scanner(System.in);
    private Scanner validateScanner = new Scanner(System.in);
    private int removeById;
    private boolean customerSelectedValidChoice = true;
    private int specificId;
    private List<Car> listOfCars = new ArrayList<>();

    //Method that is adding cars to list.
    public void addingCarsToList() {

        //Creating objects (cars)
        Car bugatti1 = new Car(1, "Bugatti", "Veyron", 3, 1000000, 25350);
        Car bentley1 = new Car(2, "Bentley", "Bentayga", 8, 8000000, 30653);
        Car lamborghini1 = new Car(3, "Lamborghini", "Huracan", 6, 7500000, 81508);
        Car bmw = new Car(4, "BMW", "X3", 7, 500000, 81508);
        Car mercedes = new Car(5, "Mercedes", "Benz", 6, 3000000, 95228);

        //Adding created cars to listOfCars.
        listOfCars.add(bugatti1);
        listOfCars.add(bentley1);
        listOfCars.add(lamborghini1);
        listOfCars.add(bmw);
        listOfCars.add(mercedes);
    }

    //Method for option number 1) Printing toString method for each car separated in console by -----
    public void showCarsInCarMart() {

        for (int i = 0; i < listOfCars.size(); i++) {
            System.out.println(listOfCars.get(i));
            System.out.println("---------------------------------------------");

        }
    }

    //Method for option number 2) Creating and adding new car object, and adding the object to list where are other car objects.
    public void sellCarToCarMart() {

        List<Integer> listOfIds = new ArrayList<Integer>();
        //Scanning car's brand and type.
        System.out.println("Write down the brand of car.");
        String brandScan = scanner.next();
        System.out.println("Write down the type of car.");
        String typeScan = scanner.next();

        //Using validateIntegerInput method for checking if scanned input is integer or string, because we need to work with integers for age, price, km.
        System.out.println("Write down the age of car.");
        int ageScan = getValidatedIntegerInput();
        System.out.println("Write down the price of car.");
        int priceScan = getValidatedIntegerInput();
        System.out.println("Write down the km on of car.");
        int kmScan = getValidatedIntegerInput();

        int i = 0;

        //For loop for listing all the cars and getting their ids. Then the program save the ids to listOfIds.
        for (Car car : listOfCars) {
            car.getId();
            listOfIds.add(car.getId());
        }

        //Do while loop for checking if listOfIds contains i, if not the specific id for car is found and set.
        do {
            i = i + 1;
            customerSelectedValidChoice = false;
            if (listOfIds.contains(i)) {

            } else {
                customerSelectedValidChoice = true;
                specificId = i;

                //Creating new object carForSale and adding it to listOfCars. Then the program clears listOfIds for working next time.
                Car carForSale = new Car(specificId, brandScan, typeScan, ageScan, priceScan, kmScan);
                listOfCars.add(carForSale);
                System.out.println("Your car was sold.");
            }
        } while (!customerSelectedValidChoice);

    }

    //Method for option number 3) Removing car object from list by his id.
    public void buyCarFromCartMart() {
        List<Integer> listOfIds = new ArrayList<Integer>();

        do {

            //User will input number for specifying what car by his id want to remove.
            removeById = getValidatedIntegerInput();
            customerSelectedValidChoice = false;

            //For loop for listing all the cars and getting their ids. Then the program save the ids to listOfIds.
            for (Car car : listOfCars) {
                car.getId();
                listOfIds.add(car.getId());
            }

            //For loop for searching the position of scanned id by checking the listOfIds with index.
            int index = -1;
            for (int i = 0; i < listOfCars.size(); i++) {
                if (listOfIds.get(i) == removeById) {
                    index = i;
                    break;
                }
            }

            //If scanned id is in listOfIds the car gets remove from listOfCars. Program already know the position by previous for loop (checking index of number).
            if (index >= 0) {
                listOfCars.remove(index);
                System.out.println("You bought a car. Enjoy it!");
                customerSelectedValidChoice = true;
                break;

            } else {
                System.out.println("Wrong Id, try again.");

            }
        } while (!customerSelectedValidChoice);
    }

    /* Method that is using scanner for checking if scanned input is String type or integer type.
       The program needs this information to not throw errors, for example if user has to input id of car.
       User inputs "red" the program would crash, because the id needs to be integer type.
    */
    private int getValidatedIntegerInput() {
        int inputtedInteger;
        if (validateScanner.hasNextInt()) {
            inputtedInteger = validateScanner.nextInt();
            return inputtedInteger;
        }

        validateScanner.next();
        System.out.println("Invalid entry. You need to input number.");
        return getValidatedIntegerInput();
    }
}
