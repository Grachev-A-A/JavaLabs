package ru.mirea.ikbo1218.grachev.exceptons;

import ru.mirea.ikbo1218.grachev.customers.Customer;
import ru.mirea.ikbo1218.grachev.menu.Alcoholable;
import ru.mirea.ikbo1218.grachev.menu.Drink;

public abstract class AlcoholForNotMatureCustomerException extends IllegalArgumentException{
    private Customer c;
    private Drink[] alcoholables;

    public AlcoholForNotMatureCustomerException(Customer c, Drink alcoholable){
        this(c, new Drink[]{alcoholable});
    }

    public AlcoholForNotMatureCustomerException(Customer c, Drink[] alcoholables){
        this.c = c;
        this.alcoholables = alcoholables;
    }

    @Override
    public String getMessage(){
        StringBuilder sb = new StringBuilder("Покупатель ");
        sb.append(c.toString()).append(" попытался заказть ");
        if(alcoholables.length > 1){
            sb.append("следующие позиции меню, содержащие алкоголь:\n");
        }else sb.append("следующий элемент меню, содержащий алкоголь: ");
        for (Drink drink: alcoholables) {
            sb.append(drink.getType()).append(", градус = ").append(drink.getAlcoholVol()).append(".\n");
        }
        sb.append("Продажа алкогольной продукции несовершеннолетним запрещена!\n");
        return sb.toString();
    }
    @Override
    public String getLocalizedMessage(){
        return this.getMessage();
    }

}
