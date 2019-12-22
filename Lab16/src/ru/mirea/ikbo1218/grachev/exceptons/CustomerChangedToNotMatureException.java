package ru.mirea.ikbo1218.grachev.exceptons;

import ru.mirea.ikbo1218.grachev.customers.Customer;
import ru.mirea.ikbo1218.grachev.menu.Alcoholable;
import ru.mirea.ikbo1218.grachev.menu.Drink;

public class CustomerChangedToNotMatureException extends AlcoholForNotMatureCustomerException{

    public CustomerChangedToNotMatureException(Customer c, Drink[] alcoholables) {
        super(c, alcoholables);
    }

    @Override
    public String getMessage() {
        return super.getMessage()+"Вся алкогольная продукция удалена из заказа.";
    }
}
