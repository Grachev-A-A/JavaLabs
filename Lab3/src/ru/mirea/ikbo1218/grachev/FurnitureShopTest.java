package ru.mirea.ikbo1218.grachev;

public class FurnitureShopTest {
    public static void main(String[] args) {
        FurnitureShop shop = new FurnitureShop(5);
        shop.add(new Table(
                "Металлический стол", 2, 1.3, 2, 2, 5930, "Металл+стекло", 0
        ));
        System.out.println(shop.getPrices());
        System.out.println("Куплено: "+ shop.buy(3));
        System.out.println(shop.getPrices());

        for (Furniture f :
                shop.getGoods()) {
            f.jumpOn();
        }
    }
}
