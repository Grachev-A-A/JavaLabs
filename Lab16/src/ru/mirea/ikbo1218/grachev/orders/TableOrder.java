package ru.mirea.ikbo1218.grachev.orders;

import ru.mirea.ikbo1218.grachev.customers.Customer;
import ru.mirea.ikbo1218.grachev.exceptons.AddingAlcoholForNotMatureCustomerException;
import ru.mirea.ikbo1218.grachev.exceptons.AlcoholForNotMatureCustomerException;
import ru.mirea.ikbo1218.grachev.menu.Alcoholable;
import ru.mirea.ikbo1218.grachev.menu.Drink;
import ru.mirea.ikbo1218.grachev.menu.MenuItem;

public class TableOrder extends AbstractOrder {

    private MenuItem[] items;

    public TableOrder(Customer c) {
        super(c);
        this.items = new MenuItem[0];
        size = 0;
    }

    private void increase(){
        MenuItem[] tmp = new MenuItem[items.length+1];
        System.arraycopy(items, 0, tmp, 0, items.length);
        items = tmp;
        size++;
    }
    private void decrease(int removedIndex){
        MenuItem[] tmp = new MenuItem[items.length-1];
        System.arraycopy(items, 0, tmp, 0, removedIndex);
        System.arraycopy(items, removedIndex+1, tmp, removedIndex, items.length-removedIndex-1);
        items = tmp;
        size--;
    }

    @Override
    public boolean add(MenuItem item) throws AlcoholForNotMatureCustomerException {
        if(item instanceof Alcoholable && ! customer.isMature() && ((Alcoholable) item).isAlcoholDrink())
            throw new AddingAlcoholForNotMatureCustomerException(customer, (Drink) item);
        increase();
        items[size-1] = item;
        return true;
    }

    @Override
    public int itemQuantity(String itemName) {
        int count = 0;
        for (MenuItem item : items) {
            if(item.getName().equals(itemName)) count++;
        }
        return count;
    }

    @Override
    public int itemQuantity(MenuItem item) {
        int count = 0;
        for (MenuItem mItem : items) {
            if(mItem.equals(item)) count++;
        }
        return count;
    }

    @Override
    public MenuItem[] getItems() {
        // А здесь лучше бы через множество сделать, но нет - использовать Collections нельзя...
        MenuItem[] uniqueItems = new MenuItem[size];
        int count = 0;
        for(int i = 0; i < size; i++){
            boolean found = false;
            for(int j = 0; j < count; j++){
                if(uniqueItems[j].equals(items[i])) {
                    found = true; break;
                }
            }
            if(!found) uniqueItems[count++] = items[i];
        }
        MenuItem[]res = new MenuItem[count];
        System.arraycopy(uniqueItems, 0, res, 0, count);
        return res;
    }

    @Override
    public boolean remove(String itemName) {
        for(int i = 0; i < size; i++){
            if(items[i].getName().equals(itemName)){
                decrease(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(MenuItem item) {
        for(int i = 0; i < size; i++){
            if(items[i].equals(item)){
                decrease(i);
                return true;
            }
        }
        return false;
    }


    @Override
    public double costTotal() {
        double cost = 0;
        for (MenuItem item : items) {
            cost += item.getCost();
        }
        return cost;
    }
}
