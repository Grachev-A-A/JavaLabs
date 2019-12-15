package ru.mirea.ikbo1218.grachev.orders;

import ru.mirea.ikbo1218.grachev.customers.Customer;
import ru.mirea.ikbo1218.grachev.exceptons.AddingAlcoholForNotMatureCustomerException;
import ru.mirea.ikbo1218.grachev.exceptons.AlcoholForNotMatureCustomerException;
import ru.mirea.ikbo1218.grachev.menu.Alcoholable;
import ru.mirea.ikbo1218.grachev.menu.MenuItem;

public class InternetOrder extends AbstractOrder {
    private static class ListNode{
        private ListNode next;
        private MenuItem value;

        ListNode(MenuItem value){
            this.value = value;
        }
        ListNode(){this(null);}

    }

    private ListNode head, tail;

    public InternetOrder(Customer c){
        super(c);
        head = tail = new ListNode();
        size = 0;
    }
    public InternetOrder(MenuItem[] arr, Customer c){
        this(c);
        if(arr == null || arr.length == 0) return;
        head = new ListNode(arr[0]);
        size++;
        ListNode node = head;
        for(int i = 1; i < arr.length; i++, size++){
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        tail = node;
    }

    @Override
    public boolean add(MenuItem item) throws AlcoholForNotMatureCustomerException {
        if(item instanceof Alcoholable && ! customer.isMature())
            throw new AddingAlcoholForNotMatureCustomerException(customer, (Alcoholable) item);
        tail.next = new ListNode(item);
        tail = tail.next;
        size++;
        return true;
    }



    @Override
    public int itemQuantity(String itemName) {
        int count = 0;
        ListNode node = head;
        while(node != null){
            if(node.value.getName().equals(itemName)) count++;
            node = node.next;
        }
        return count;
    }

    @Override
    public int itemQuantity(MenuItem item) {
        int count = 0;
        ListNode node = head;
        while(node != null){
            if(node.value.equals(item)) count++;
            node = node.next;
        }
        return count;
    }

    @Override
    public MenuItem[] getItems() {
        MenuItem[] items = new MenuItem[0];
        ListNode node = head;
        while(node != null){
            boolean found = false;
            for (MenuItem item : items) {
                if (item.equals(node.value)) {
                    found = true;
                    break;
                }
            }
            if(!found){
                MenuItem[] tmp = new MenuItem[items.length+1];
                System.arraycopy(items, 0, tmp, 0, items.length);
                tmp[tmp.length-1] = node.value;
                items = tmp;
            }
            node = node.next;
        }
        return items;
    }

    @Override
    public boolean remove(String itemName) {
        ListNode node = head, prevNode = null;

        while(node != null){
            if(node.value.getName().equals(itemName)){
                if(prevNode != null) prevNode.next = node.next;
                if (node == tail) tail = prevNode;
                if(node == head) head = head.next;
                size--;
                return true;
            }
            prevNode = node;
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean remove(MenuItem item) {
        ListNode node = head, prevNode = null;
        while(node != null){
            if(node.value.equals(item)){
                if(prevNode != null) prevNode.next = node.next;
                if (node == tail) tail = prevNode;
                if(node == head) head = head.next;
                size--;
                return true;
            }
            prevNode = node;
            node = node.next;
        }
        return false;
    }

    @Override
    public double costTotal() {
        double cost = 0;
        ListNode node = head;
        while (node != null){
            cost+=node.value.getCost();
            node = node.next;
        }
        return cost;
    }
}
