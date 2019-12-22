package ru.mirea.ikbo1218.grachev.gui;

import ru.mirea.ikbo1218.grachev.exceptons.NoOrderForTableException;
import ru.mirea.ikbo1218.grachev.gui.parts.GeneralMenu;
import ru.mirea.ikbo1218.grachev.gui.parts.OrderUI;
import ru.mirea.ikbo1218.grachev.orders.Order;

import javax.swing.*;
import java.awt.*;

public class KitchenWindow extends JFrame {

    private JLabel summaryLabel;
    private JPanel tablesOrders;

    public KitchenWindow(int tablesCount){
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(480, 480);
        summaryLabel = new JLabel("Заказов в ресторане: 0, заказов через интернет: 0");
        tablesOrders = new JPanel();
        tablesOrders.setLayout(new BoxLayout(tablesOrders, BoxLayout.Y_AXIS));
        for(int i = 0; i < tablesCount; i++){

            class OrderWindow extends JFrame{
                OrderWindow(OrderUI ui, int i){
                    getContentPane().add(new JScrollPane(ui), BorderLayout.CENTER);
                    setSize(160, 480);
                    JButton b = new JButton("Выполнен");
                    b.addActionListener(e-> {
                        Controller.getInstance().removeOrder(i);
                        this.dispose();
                    });
                    getContentPane().add(b, BorderLayout.SOUTH);
                }
            }
            JButton b = new JButton("Столик № "+(i+1));
            b.addActionListener(e->{
                try{
                    var ow = new OrderWindow(new OrderUI(Controller.getInstance().getOrder(Integer.parseInt(b.getText().substring(9)) - 1)),
                            Integer.parseInt(b.getText().substring(9)) -1);
                    ow.setVisible(true);
                }catch (NoOrderForTableException ex){
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Нет заказа!", JOptionPane.INFORMATION_MESSAGE);
                }
            });
            tablesOrders.add(b);
        }

        var sp = new JScrollPane(tablesOrders);
        getContentPane().add(summaryLabel, BorderLayout.NORTH);
        getContentPane().add(sp, BorderLayout.WEST);
        JPanel p = new JPanel();
        JButton b = new JButton("Выполнить");
        b.addActionListener(e->Controller.getInstance().removeOrder());
        getContentPane().add(p);
        setIntOrder(null);
        p.add(b);

        JMenu kMenu = new JMenu("Кухня");
        JMenuItem stat = new JMenuItem("Полная статистика заказов");
        stat.addActionListener(e->Controller.getInstance().openFullStat());
        kMenu.add(stat);
        setJMenuBar(new GeneralMenu(this, new JMenu[]{kMenu}));
    }

    public void updateDataLabel(int t, int i){
        summaryLabel.setText("Заказов в ресторане: " + t + ", заказов через интернет: "+i);
    }

    public void notifyTableOrderAdded(int num){
        ((JButton)tablesOrders.getComponent(num)).setIcon(new ImageIcon(this.getClass().getResource("img/hasOrder.png")));
    }

    public void setIntOrder(Order o){
        if(((JPanel)getContentPane().getComponent(2)).getComponentCount() > 0)
            ((JPanel)getContentPane().getComponent(2)).remove(0);
        if(o == null) {
            ((JPanel)getContentPane().getComponent(2)).add(new JLabel("Интернет заказов пока нет!"), 0);
        }else{
            ((JPanel)getContentPane().getComponent(2)).add(new OrderUI(o), 0);
        }
    }

    public void onRemoveOrder(int tNum) {
        ((JButton)tablesOrders.getComponent(tNum)).setIcon(null);
    }
}
