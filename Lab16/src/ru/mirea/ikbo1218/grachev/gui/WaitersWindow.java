package ru.mirea.ikbo1218.grachev.gui;

import ru.mirea.ikbo1218.grachev.exceptons.NoFreeTablesException;
import ru.mirea.ikbo1218.grachev.gui.parts.GeneralMenu;
import ru.mirea.ikbo1218.grachev.gui.parts.OrderPane;

import javax.swing.*;
import java.awt.*;

public class WaitersWindow extends JFrame {

    private JTabbedPane wTables;

    public WaitersWindow(){
        setSize(860, 320);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        wTables = new JTabbedPane();
        wTables.setTabPlacement(SwingConstants.RIGHT);
        var newGuest = new JButton("Обслужить гостя");
        newGuest.addActionListener(e->{
            int[] tn;
            try{
                tn = Controller.getInstance().getFreeNums();
            }catch (NoFreeTablesException ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
                return;
            }
            Integer[] tno = new Integer[tn.length];
            for (int i = 0; i < tn.length; i++) {
                tno[i] = tn[i]+1;
            }
            Integer t = (Integer) JOptionPane.showInputDialog(this, "Укажите столик: ", "Начать обработку заказа", JOptionPane.INFORMATION_MESSAGE, null, tno,  tno[0]);
            try{
                Controller.getInstance().addOrder(t-1, JOptionPane.showConfirmDialog(this, "Гость - совершеннолетний?", "Начало работы с клиентом", JOptionPane.YES_NO_OPTION) == 0);
            }catch (NullPointerException ignored){}

            wTables.addTab("Столик № "+t, new OrderPane(t-1));

        });

        getContentPane().add(newGuest, BorderLayout.NORTH);
        getContentPane().add(wTables, BorderLayout.CENTER);

        setJMenuBar(new GeneralMenu(this, new JMenu[0]));
    }

    public void onRemovedOrder(int tNum){
        for(int i = 0; i < wTables.getTabCount(); i++){
            if(Integer.parseInt(wTables.getTitleAt(i).substring(9)) - 1 == tNum){
                wTables.removeTabAt(i);
                break;
            }
        } }
}
