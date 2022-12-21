package org.example;

import java.util.*;

/*
Training for object programming, basics.
 */
public class Main {

        /*Main method works for
          1)Showing the list of all objects (cars)
          2)Selling the car to list (creating, adding parameters and adding new car object to list of cars)
          3)Buying the car from list (removing car from list by id)
          4)Exiting program.
         */
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //removeById is needed integer for scanner and integer r set to 1 is for do while loop working.
        int removeById;
        boolean customerSelectedValidChoice = true;
        boolean unusedCarIdFound = true;
        List<Integer> listOfIds = new ArrayList<Integer>();
        List<Integer> sortedListOfIds = new ArrayList<>();


        int specificID;

        //Creating objects (cars) + adding them to listOfCars.
            Car bugatti1 = new Car(1,"Bugatti", "Veyron", 3, 1000000, 25350);
            Car bentley1 = new Car(2, "Bentley", "Bentayga", 8, 8000000, 30653);
            Car lamborghini1 = new Car(3, "Lamborghini","Huracan", 6, 7500000, 81508 );
            Car bmw = new Car(4, "BMW","X3", 7, 500000, 81508 );
            Car mercedes = new Car(5, "Mercedes","Benz", 6, 3000000, 95228 );

        ArrayList<Car> listOfCars = new ArrayList<>();
        listOfCars.add(bugatti1);
        listOfCars.add(bentley1);
        listOfCars.add(lamborghini1);
        listOfCars.add(bmw);
        listOfCars.add(mercedes);



        //Introduction + repeatText is needed for do while loops (menu cant end, only if user input number 4) for option.
       System.out.println("Welcome to car mart.");
       String repeatText ="Choose a number for continue " + "\n" + "1) List of cars in car mart." + "\n" + "2) Sell a car." + "\n" + "3) Buy a car." + "\n" + "4) Stop application. ";
       System.out.println(repeatText);

       //scanner what option user wants to use.
        int option = scanner.nextInt();

        //Do while loop
        do {

            //1. Option number 1) printing toString method for each car separated in console by -----
            if(option ==1) {
                System.out.println("Here you can see the list of cars in out car mart: ");
                for (int i = 0; i < listOfCars.size(); i++) {
                    System.out.println(listOfCars.get(i));
                    System.out.println("---------------------------------------------");

                }
                System.out.println(repeatText);
                option = scanner.nextInt();
            }

            //2. Option number 2) creating and adding new car object, and adding the object to list where are other car objects.
                else if (option ==2) {
                System.out.println("Ok, you want to sell a car. Write down one by one the car's Brand, type, age, price, km.");

                //the id needs to be automatic and so it's set to list size +1. it has to be unique.



                      //listOfCars.contains();
                    System.out.println("Write down the brand of car.");
                    String brandScan = scanner.next();
                    System.out.println("Write down the type of car.");
                    String typeScan = scanner.next();
                    System.out.println("Write down the age of car.");
                    int ageScan = scanner.nextInt();
                    System.out.println("Write down the price of car.");
                    int priceScan = scanner.nextInt();
                    System.out.println("Write down the km on of car.");
                    int kmScan = scanner.nextInt();

                int i = 0;


                do {
                    for (Car car : listOfCars) {
                        car.getId();
                        listOfIds.add(car.getId());
                    }
                    i = i+1;
                    customerSelectedValidChoice = false;
                        if (listOfIds.contains(i)) {

                        } else {

                    customerSelectedValidChoice =true;
                    specificID = i  ;

                    Car sellingCar = new Car(specificID, brandScan, typeScan, ageScan, priceScan, kmScan);
                    listOfCars.add(sellingCar);
                    listOfIds.clear();
                 }
                }while(!customerSelectedValidChoice);

                    //Setting specificID + scanning other parameters of car object by scanner.

                System.out.println(repeatText);
                option = scanner.nextInt();
            }

            //3. Option number 3) Removing car object from list by his id.
                else if(option ==3) {
                System.out.println("Ok, you want to buy a car. Select a car by writing the car's ID.");

                do {
                    removeById = scanner.nextInt();
                    customerSelectedValidChoice = false;

                    for (Car car : listOfCars) {
                        car.getId();
                        listOfIds.add(car.getId());
                    }

                    int index = -1;
                    for (int i = 0; i < listOfCars.size(); i++) {
                        if (listOfIds.get(i) == removeById) {
                            index = i;
                            break;
                        }
                    }
                    if (index >= 0) {
                        listOfCars.remove(index);
                        System.out.println("You bought a car. Enjoy it!");
                        System.out.println(repeatText);
                        customerSelectedValidChoice = true;
                        listOfIds.clear();
                        break;

                    } else {
                        System.out.println("Wrong Id, try again.");

                    }

                // condition is r==1 because I needed to do else option, where r=2 so program will continue while writing good id car. "Want to talk about it."
                } while (!customerSelectedValidChoice);
                     option = scanner.nextInt();
            }
                //if user input unknown number, command.
                else {
                System.out.println("Unknown command, try again");

                System.out.println(repeatText);
                option = scanner.nextInt();


            }

          //While option isn't 4, loop is continuing to loop. If user input number 4 for option scanner, program will end.
        } while(option != 4);
            System.out.println("See you next time.");

        }
    }











