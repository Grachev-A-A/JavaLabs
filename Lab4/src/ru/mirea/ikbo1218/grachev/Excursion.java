package ru.mirea.ikbo1218.grachev;

public class Excursion implements Priceable{
    private String name;
    private double price;
    private double percent;

    public Excursion(String name, double price, double percent) {
        this.name = name;
        this.price = price;
        this.percent = percent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price*percent;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "Excursion{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", percent=" + percent +
                '}';
    }
}
