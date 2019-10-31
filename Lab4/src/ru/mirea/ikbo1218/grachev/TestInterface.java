package ru.mirea.ikbo1218.grachev;


public class TestInterface {
    public static void main(String[] args) {
        Priceable p = new Excursion("Путевка в Мексику", 55400, 1.205);
        System.out.println(p);
        System.out.println(p.getPrice());
        p = new Laptop(12000, "Какая-то модель");
        System.out.println(p);
        p = new Mouth(800, 1800, "Черный");
        System.out.println(p);
    }

}
