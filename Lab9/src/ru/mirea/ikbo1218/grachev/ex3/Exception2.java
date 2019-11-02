package ru.mirea.ikbo1218.grachev.ex3;

import java.util.Scanner;

/*
С помощью перехватывания исключений можно оказывать влияние на поведение программы.
В вашем решении в предыдущем упражнении вы можете добавить новый пункт - catch в начале списка пунктов catch.
Выполите это, чтобы поймать общее исключение класса Exception.
Перезапустите программу с приведенными выше данными и обратите внимание на ее поведение. Объясните новое поведение программы

 */

public class Exception2 {
    public void exceptionDemo() {
        try {
            Scanner myScanner = new Scanner(System.in);
            System.out.print("Enter an integer ");
            String intString = myScanner.next();
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        }
        catch (NumberFormatException e){             // Compile error: NumberFormatException already catched
                System.out.println("Not correct number");
        }
        catch(Exception e) {
            System.out.println("Exception happened!");
        }
    }

    public static void main(String[] args) {
        Exception2 e2 = new Exception2();
        e2.exceptionDemo();
    }
}
