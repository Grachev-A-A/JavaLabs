package ru.mirea.ikbo1218.grachev.orders.managers;

import ru.mirea.ikbo1218.grachev.exceptons.IllegalTableNumberException;
import ru.mirea.ikbo1218.grachev.exceptons.NoFreeTablesException;
import ru.mirea.ikbo1218.grachev.exceptons.NoOrderForTableException;
import ru.mirea.ikbo1218.grachev.exceptons.TableAlreadyOrderedException;
import ru.mirea.ikbo1218.grachev.menu.MenuItem;
import ru.mirea.ikbo1218.grachev.orders.Order;

public class TableOrderManager implements OrderManager {

    private Order[] orders;

    public TableOrderManager(){
        this(32);
    }
    public TableOrderManager(int tableCount){
        orders = new Order[tableCount];
    }

    public void add(Order order, int tNum) throws IllegalTableNumberException, TableAlreadyOrderedException{
        if(tNum >= orders.length) throw new IllegalTableNumberException(tNum, orders.length-1);
        if(orders[tNum]!=null) throw new TableAlreadyOrderedException(tNum);
        orders[tNum] = order;
    }

    public  void addItem(MenuItem item, int tNum) throws  IllegalTableNumberException, NoOrderForTableException{
        if(tNum >= orders.length) throw new IllegalTableNumberException(tNum, orders.length-1);
        if(orders[tNum] == null) throw new NoOrderForTableException(tNum);
        orders[tNum].add(item);

    }


    @Override
    public int itemsQuantity(String itemName) {
        int count = 0;
        for (Order o : orders) {
            if (o != null) count += o.itemQuantity(itemName);
        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int count = 0;
        for (Order o : orders) {
            if (o != null) count += o.itemQuantity(item);
        }
        return count;    }

    @Override
    public Order[] getOrders() {
        Order[] tmp = new Order[orders.length];
        int j = 0;
        for (Order order : orders) {
            if (order != null) tmp[j++] = order;
        }
        Order[]res = new Order[j];
        System.arraycopy(tmp, 0, res, 0, j);

        return res;
    }

    public int freeTableNumber() throws NoFreeTablesException {
        for(int i = 0; i < orders.length; i++){
            if(orders[i] == null) return i;
        }
        throw new NoFreeTablesException(orders.length);
    }

    public int[] freeTableNumbers() throws NoFreeTablesException{
        int[] nums = new int[0];
        for(int i = 0; i < orders.length; i++){
            if(orders[i] == null){
                int[]tmp=new int[nums.length+1];
                System.arraycopy(nums, 0, tmp, 0, nums.length);
                tmp[tmp.length-1] = i;
                nums = tmp;
            }
        }
        if(nums.length > 0) return nums;
        throw new NoFreeTablesException(orders.length);
    }
    public Order getOrder(int tNum) throws NoOrderForTableException{
        if(orders[tNum] == null) throw new NoOrderForTableException(tNum);
        return orders[tNum];
    }

    public void remove(int tNum){
        orders[tNum] = null;
    }

    public boolean remove(Order order){
        for(int i = 0; i < orders.length; i++){
            if(orders[i].equals(order)){
                orders[i] = null;
                return true;
            }
        }
        return false;
    }

    public int removeAll(Order order){
        int count = 0;
        while(remove(order)) count++;
        return count;
    }

    @Override
    public double ordersCostSummary() {
        double cost = 0;
        for(int i = 0; i < orders.length; i++){
            if(orders[i] != null) cost+= orders[i].costTotal();
        }
        return cost;
    }

    @Override
    public int ordersQuantity() {
        return getOrders().length;
    }
}
