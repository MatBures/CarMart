package org.example;

import java.util.List;

/*Car class with parameters, creating instance.
  Needed for getId getter and toString method.
*/
public class Car {
    private int id;
    private String brand;
    private String type;
    private int age;
    private int price;
    private int km;


    public Car(int id, String brand, String type, int age, int price, int km) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.age = age;
        this.price = price;
        this.km = km;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return id + ", " + brand + ", " + type + ", " + age + ", " + price + ", " + km;
    }
}
