package ru.mirea.ikbo1218.grachev;

public abstract class Good implements Priceable {
    private double price;

    public Good(double price) {
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "price=" + price;
    }
}
