package ru.mirea.ikbo1218.grachev;

public class Laptop extends Good{
    private String model;

    public Laptop(double price, String model) {
        super(price);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "model='" + model + '\'' + ", " + super.toString() +
                '}';
    }
}
