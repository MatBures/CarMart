package CarMart;

/**
 * Car class with parameters, creating instance.
 * Needed for getId getter and toString method.
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

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public int getPrice() {
        return price;
    }

    public int getKm() {
        return km;
    }

    public String toString() {
        return id + ", " + brand + ", " + type + ", " + age + ", " + price + ", " + km;
    }
}

