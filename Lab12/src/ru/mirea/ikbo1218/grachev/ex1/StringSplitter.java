package ru.mirea.ikbo1218.grachev.ex1;

import java.util.Arrays;
import java.util.Scanner;

public class StringSplitter {
    public static void main(String[] args) {
        System.out.println("Введите строку:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Введитк паттерн:");
        String p = sc.nextLine();
        System.out.println(Arrays.toString(str.split(p)));
    }
}
