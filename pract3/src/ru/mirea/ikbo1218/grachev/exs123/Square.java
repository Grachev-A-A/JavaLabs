package ru.mirea.ikbo1218.grachev.exs123;

public class Square extends Rectangle {
    public Square() {
        super();
    }
    public Square(double side){
        super(side, side);
    }
    public Square(double side, String colour, boolean filled){
        super(colour, filled, side, side);
    }

    public double getSide() {return width;}
    public void setSide(double side){
        width = side;
        length = side;
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(length);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(width);
    }

    @Override
    public String toString() {
        return "Square{" +
                "width=" + width +
                ", length=" + length +
                ", colour='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
