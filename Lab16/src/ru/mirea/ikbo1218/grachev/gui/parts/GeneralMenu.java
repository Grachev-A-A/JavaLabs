package ru.mirea.ikbo1218.grachev.gui.parts;

import ru.mirea.ikbo1218.grachev.gui.Controller;

import javax.swing.*;
import java.awt.*;

public class GeneralMenu extends JMenuBar {

    public GeneralMenu(Component parent, JMenu[] others){
        JMenu fileMenu = new JMenu("Файл");

        JMenuItem showAll = new JMenuItem("Показать все окна");
        showAll.addActionListener(e-> Controller.getInstance().showAll());
        fileMenu.add(showAll);

        var exit = new JMenuItem("Выход");
        exit.addActionListener(e->System.exit(0));
        fileMenu.add(exit);

        this.add(fileMenu);

        for(var m: others){
            this.add(m);
        }
    }
}
