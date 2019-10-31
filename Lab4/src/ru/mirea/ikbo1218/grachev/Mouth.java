package ru.mirea.ikbo1218.grachev;

public class Mouth extends Good{
    private int dpi;
    private String color;

    public Mouth(double price, int dpi, String color) {
        super(price);
        this.dpi = dpi;
        this.color = color;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Mouth{" +
                "dpi=" + dpi +
                ", color='" + color + '\'' + ", " + super.toString() +
                '}';
    }
}
