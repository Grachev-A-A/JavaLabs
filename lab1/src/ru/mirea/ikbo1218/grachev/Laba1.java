package ru.mirea.ikbo1218.grachev;

import java.util.Arrays;
import java.util.Random;

public class Laba1 {
    public static void main(String[] args) {
        Random r = new Random(System.currentTimeMillis());
        int[] arr = new int[10];
        System.out.println("Изначальный массив:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
            System.out.println("Arr["+i+"] = " + arr[i]);
        }
        Arrays.sort(arr);
        System.out.println("Отсортированный массив: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Arr["+i+"] = "+arr[i]);
        }

    }
}
