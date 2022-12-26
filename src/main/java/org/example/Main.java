package org.example;

import java.util.*;


public class Main {

    /*Main method has 4 options that user can use.
      1)Showing the list of all cars by showCarsInCarMart method.
      2)Selling the car to list by sellCarToCarMart method.
      3)Buying the car from list by buyCarFromCartMart method.
      4)Exiting program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarMart carMart = new CarMart();

        //Adding cars to list by method.
        carMart.addingCarsToList();


        //Introduction + repeatText is needed for do while loops (menu cant end, only if user input number 4) for option.
        System.out.println("Welcome to car mart.");
        String repeatText = "Choose a number for continue " + "\n" + "1) List of cars in car mart." + "\n" + "2) Sell a car." + "\n" + "3) Buy a car." + "\n" + "4) Stop application. ";
        System.out.println(repeatText);

        //scanner what option user wants to use.
        int option = scanner.nextInt();

        //Do while loop
        do {

            //1. Option number 1) Using showCarsInCarMart method for printing all cars with parameters to console separated by -------
            if (option == 1) {
                System.out.println("Here you can see the list of cars in out car mart: ");
                carMart.showCarsInCarMart();
                System.out.println(repeatText);
                option = scanner.nextInt();
            }

            //2. Option number 2) Using sellCarToCarMart for creating and adding new car object and adding the object to list where are other car objects.
            else if (option == 2) {
                System.out.println("Ok, you want to sell a car. Write down one by one the car's Brand, type, age, price, km.");
                carMart.sellCarToCarMart();
                System.out.println(repeatText);
                option = scanner.nextInt();
            }

            //3. Option number 3) Removing car object from list by his id.
            else if (option == 3) {
                System.out.println("Ok, you want to buy a car. Select a car by writing the car's id.");
                carMart.buyCarFromCartMart();
                System.out.println(repeatText);
                option = scanner.nextInt();

            }
            //if user input unknown number, command.
            else {
                System.out.println("Unknown command, try again");
                System.out.println(repeatText);
                option = scanner.nextInt();

            }

        //While option isn't 4, loop is continuing to loop. If user input number 4 for option scanner, program will end.
        } while (option != 4);
        System.out.println("See you next time.");
    }
}











