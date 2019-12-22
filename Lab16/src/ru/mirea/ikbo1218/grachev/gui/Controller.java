package ru.mirea.ikbo1218.grachev.gui;


import ru.mirea.ikbo1218.grachev.customers.Address;
import ru.mirea.ikbo1218.grachev.customers.Customer;
import ru.mirea.ikbo1218.grachev.exceptons.AlcoholForNotMatureCustomerException;
import ru.mirea.ikbo1218.grachev.exceptons.EmptyOrderListException;
import ru.mirea.ikbo1218.grachev.exceptons.NoFreeTablesException;
import ru.mirea.ikbo1218.grachev.menu.Dish;
import ru.mirea.ikbo1218.grachev.menu.Drink;
import ru.mirea.ikbo1218.grachev.menu.DrinkTypeEnum;
import ru.mirea.ikbo1218.grachev.orders.InternetOrder;
import ru.mirea.ikbo1218.grachev.orders.Order;
import ru.mirea.ikbo1218.grachev.orders.TableOrder;
import ru.mirea.ikbo1218.grachev.orders.managers.InternetOrderManager;
import ru.mirea.ikbo1218.grachev.orders.managers.TableOrderManager;
import ru.mirea.ikbo1218.grachev.menu.MenuItem;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.*;

public class Controller implements Runnable{
    private KitchenWindow kw;
    private InternetUserWindow iw;
    private WaitersWindow ww;

    private InternetOrderManager iom;
    private TableOrderManager tom;

    private FStat f;

    private static Controller instance;
    private Controller(){
        tom = new TableOrderManager();
        iom = new InternetOrderManager();

        kw = new KitchenWindow(32);
        kw.setVisible(true);
        iw = new InternetUserWindow();
        iw.setVisible(true);
        ww = new WaitersWindow();
        ww.setVisible(true);
        new Thread(this).start();
    }

    public int[] getFreeNums() throws NoFreeTablesException {return tom.freeTableNumbers();}

    private class FStat extends JFrame implements Runnable{

        FStat(){
            super("Статистика заказов");
            setLayout(new GridLayout(0, 2));
            getContentPane().add(new JLabel("Интернет заказы:"));
            getContentPane().add(new JLabel(""));
            getContentPane().add(new JLabel("Всего заказов:"));
            getContentPane().add(new JLabel(Integer.toString(iom.ordersQuantity())));
            getContentPane().add(new JLabel("Планируемая выручка:"));
            getContentPane().add(new JLabel(Double.toString(iom.ordersCostSummary())));
            getContentPane().add(new JLabel("Заказы в ресторане:"));
            getContentPane().add(new JLabel(""));
            getContentPane().add(new JLabel("Столиков занято:"));
            getContentPane().add(new JLabel(Integer.toString(tom.ordersQuantity())));
            getContentPane().add(new JLabel("Планируемая выручка:"));
            getContentPane().add(new JLabel(Double.toString(tom.ordersCostSummary())));
            getContentPane().add(new JLabel("Вместе:"));
            getContentPane().add(new JLabel(""));
            getContentPane().add(new JLabel("Планируемая выручка:"));
            getContentPane().add(new JLabel(Double.toString(tom.ordersCostSummary() + iom.ordersCostSummary())));
            setSize(320, 320);
            setDefaultCloseOperation(HIDE_ON_CLOSE);
            new Thread(this).start();
        }

        @Override
        public void run() {
            while (true){
                ((JLabel)getContentPane().getComponent(3)).setText(Integer.toString(iom.ordersQuantity()));
                ((JLabel)getContentPane().getComponent(5)).setText(Double.toString(iom.ordersCostSummary()));
                ((JLabel)getContentPane().getComponent(9)).setText(Integer.toString(tom.ordersQuantity()));
                ((JLabel)getContentPane().getComponent(11)).setText(Double.toString(tom.ordersCostSummary()));
                ((JLabel)getContentPane().getComponent(15)).setText(Double.toString(tom.ordersCostSummary() + iom.ordersCostSummary()));
            }
        }
    }

    public void openFullStat(){
        if(f == null) f = new FStat();
        f.setVisible(true);

    }
    public void showAll(){
        kw.setVisible(true);
        iw.setVisible(true);
        ww.setVisible(true);
    }

    public void addOrder(int tNum, boolean mature){
        var to = new TableOrder(mature ? Customer.MATURE_UNKNOWN_CUSTOMER : Customer.NOT_MATURE_UNKNOWN_CUSTOMER);
        try{
            tom.add(to, tNum);
        }catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(ww, e.getMessage(), "Ошибка номера столика!", JOptionPane.WARNING_MESSAGE);
        }
        kw.notifyTableOrderAdded(tNum);
    }

    public void addToOrder(String[] arr, int tNum){
        MenuItem mi;
        try{
            if(arr.length == 3)
                mi = new Dish(arr[0], arr[1], Double.parseDouble(arr[2]));
            else mi = new Drink(arr[0], arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), DrinkTypeEnum.valueOf(arr[4]));
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(ww, "Ошибка ввода числа:\n"+e.getMessage(), "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try{
            tom.addItem(mi, tNum);
        }catch (AlcoholForNotMatureCustomerException e){
            JOptionPane.showMessageDialog(ww, e.getMessage(), "Алкоголь нельзя!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void addOrder(String[][] ord){
        MenuItem[] itms = new MenuItem[ord.length];
        for(int i = 0; i< ord.length; i++){
            try{
                if(ord[i].length == 3)
                    itms[i] = new Dish(ord[i][0], ord[i][1], Double.parseDouble(ord[i][2]));
                else itms[i] = new Drink(ord[i][0], ord[i][1], Double.parseDouble(ord[i][2]), Double.parseDouble(ord[i][3]), DrinkTypeEnum.valueOf(ord[i][4]));
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(iw, "В элементе заказа номер "+ (i+1)+ " введено некорректное число.");
                return;
            }
        }
        String [] c = iw.askCustomer();
        Customer cast;
        try{
            cast = new Customer(
                    c[0], c[1], Integer.parseInt(c[2]),
                    new Address(c[3], Integer.parseInt(c[4]), c[5], Integer.parseInt(c[6]), c[7].charAt(0), Integer.parseInt(c[8]))
            );
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(iw, "Вы ввели некорректное число. Повторите попытку позже.");
            return;
        }
        InternetOrder io;
        try{
            io = new InternetOrder(itms, cast);
        }catch (AlcoholForNotMatureCustomerException e){
            JOptionPane.showMessageDialog(iw, e.getMessage());
            return;
        }
        iom.add(io);
        if(iom.ordersQuantity() == 1) kw.setIntOrder(iom.order());
        JOptionPane.showMessageDialog(iw, "Заказ поставлен в очередь обработки!");
    }

    public Order getOrder(int tableNum){
        return tom.getOrder(tableNum);
    }
    public void removeOrder(int tNum){
        tom.remove(tNum);
        ww.onRemovedOrder(tNum);
        kw.onRemoveOrder(tNum);
    }
    public void removeOrder(){
        try {
            iom.remove();
        }catch (EmptyOrderListException e){
            JOptionPane.showMessageDialog(kw, "В очереди нет заказов!");
        }
        try{
            kw.setIntOrder(iom.order());
        }catch (EmptyOrderListException e){
            kw.setIntOrder(null);
        }
    }

    public static Controller getInstance(){
        if(instance == null) instance = new Controller();
        return instance;
    }

    @Override
    public void run() {
        while (true) {
            if (!kw.isVisible() && !iw.isVisible() && !ww.isVisible())
                System.exit(0);
            kw.updateDataLabel(tom.ordersQuantity(), iom.ordersQuantity());
        }

    }


    public static void main(String[] args) {
        Controller.getInstance();
    }
}
