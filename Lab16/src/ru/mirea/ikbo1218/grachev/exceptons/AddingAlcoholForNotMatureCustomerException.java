package ru.mirea.ikbo1218.grachev.exceptons;

import ru.mirea.ikbo1218.grachev.customers.Customer;
import ru.mirea.ikbo1218.grachev.menu.Alcoholable;
import ru.mirea.ikbo1218.grachev.menu.Drink;

public class AddingAlcoholForNotMatureCustomerException extends AlcoholForNotMatureCustomerException {
    public AddingAlcoholForNotMatureCustomerException(Customer c, Drink alcoholable) {
        super(c, alcoholable);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "Элемент не добавлен в заказ.";
    }
}
