package ru.mirea.ikbo1218.grachev.exs123;

public class ShapeTest {
    public static void main(String[] args) {
        Shape s1 = new Circle("RED", false, 5.5);  // Upcast Circle to Shape
        // Returns of Circle methods, defined in Shape
        System.out.println(s1);
        System.out.println(s1.getArea());
        System.out.println(s1.getPerimeter());
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());
        //System.out.println(s1.getRadius());   // Not in Shape

        System.out.println();

        Circle c1 = (Circle)s1;                   // Downcast back to Circle
        // Returns of Circle methods
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());


        System.out.println();
        //Shape s2 = new Shape();   //  Abstract

        Shape s3 = new Rectangle("RED", false, 1.0, 2.0);   // Upcast
        // Returns of Rectangle methods, defined in Shape
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());
        //System.out.println(s3.getLength()); // NOT in Shape

        System.out.println();

        Rectangle r1 = (Rectangle)s3;   // downcast
        // Returns of Rectangle methods
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColor());
        System.out.println(r1.getLength());

        System.out.println();

        Shape s4 = new Square(6.6);     // Upcast
        // Returns of Square methods, defined in Shape
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
        //System.out.println(s4.getSide());  // NOT in Rectangle

        System.out.println();

        // Take note that we downcast Shape s4 to Rectangle,
        //  which is a superclass of Square, instead of Square
        Rectangle r2 = (Rectangle)s4;
        // Returns of Square methods, defined in Rectangle
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());
        //System.out.println(r2.getSide());  // Not in Rectangle
        System.out.println(r2.getLength());

        System.out.println();

        // Downcast Rectangle r2 to Square
        Square sq1 = (Square)r2;
        // Returns of Square methods
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide());
        System.out.println(sq1.getLength());

    }
}
