package ru.mirea.ikbo1218.grachev.ex2;

public class Ball {
    private  int radius;
    private String color;

    public Ball(int radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public Ball(int radius) {
        this.radius = radius;
        this.color = "Красный";
    }

    public Ball(String color) {
        this.radius = 1;
        this.color = color;
    }

    public Ball() {
        this.radius = 1;
        this.color = "Красный";
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }

    public int getDiametr(){
        return 2*radius;
    }
}
