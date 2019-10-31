package ru.mirea.ikbo1218.grachev.ex2;

public class TestBall {
    public static void main(String[] args) {
        Ball b = new Ball();
        System.out.println(b);
        b.setXY(2.6, 4.9);
        System.out.println(b);
        b.move(12, -4);
        System.out.println(b);
    }
}
