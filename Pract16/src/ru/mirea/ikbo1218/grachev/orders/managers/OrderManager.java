package ru.mirea.ikbo1218.grachev.orders.managers;

import ru.mirea.ikbo1218.grachev.menu.MenuItem;
import ru.mirea.ikbo1218.grachev.orders.Order;

public interface OrderManager {
    int itemsQuantity(String itemName);
    int itemsQuantity(MenuItem item);
    Order[] getOrders();
    double ordersCostSummary();
    int ordersQuantity();
}
