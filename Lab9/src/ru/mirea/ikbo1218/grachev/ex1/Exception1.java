package ru.mirea.ikbo1218.grachev.ex1;

public class Exception1 {
    public void exceptionDemo(){
        System.out.println(2/0);
    }
    public void exceptionDemo2(){
        try{
            System.out.println( 2 / 0 );
        } catch ( ArithmeticException e ) {
            System.out.println("Attempted division by zero");
        }
    }

    public static void main(String[] args) {
        Exception1 e1 = new Exception1();
        e1.exceptionDemo2();
        e1.exceptionDemo();

    }
}
