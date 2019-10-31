package ru.mirea.ikbo1218.grachev.exs123;

public class Circle extends Shape {

    protected double radius;

    public Circle(String colour, boolean filled, double radius) {
        super(colour, filled);
        this.radius = radius;
    }

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public Circle() {
        super();
        radius = 0;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", colour='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }

    @Override
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }
}
