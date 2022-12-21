package org.example;

import java.util.ArrayList;
import java.util.List;

public class CarMart {

    public Car generateList() {

        //Creating objects (cars) + adding them to listOfCars.
        Car bugatti1 = new Car(1, "Bugatti", "Veyron", 3, 1000000, 25350);
        Car bentley1 = new Car(2, "Bentley", "Bentayga", 8, 8000000, 30653);
        Car lamborghini1 = new Car(3, "Lamborghini", "Huracan", 6, 7500000, 81508);
        Car bmw = new Car(4, "BMW", "X3", 7, 500000, 81508);
        Car mercedes = new Car(5, "Mercedes", "Benz", 6, 3000000, 95228);

        List<Car> llist = new ArrayList<>();

        List<Car> listOfCars = new ArrayList<>();
        listOfCars.add(bugatti1);
        listOfCars.add(bentley1);
        listOfCars.add(lamborghini1);
        listOfCars.add(bmw);
        listOfCars.add(mercedes);

        Car car =new Car(listOfCars);

        return car;

    }
}
