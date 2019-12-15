package ru.mirea.ikbo1218.grachev.menu;

public abstract class MenuItem implements Comparable<MenuItem>{
    private String name, description;
    private double cost;

    public MenuItem(String name, String description, double cost) throws IllegalArgumentException {
        if(!name.equals(""))
            this.name = name;
        else throw new IllegalArgumentException("Передано некорректное название элемента меню!");
        if(!description.equals(""))
            this.description = description;
        else throw new IllegalArgumentException("Передано некорректное описание элемента меню!");
        if(cost > 0)
            this.cost = cost;
        else throw new IllegalArgumentException("Передана некорректная цена для элемента меню!");
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof MenuItem && name.equals(((MenuItem) obj).name) && description.equals(((MenuItem) obj).description)
                && cost == ((MenuItem) obj).cost;
    }

    @Override
    public int compareTo(MenuItem o) {
        return (int)Math.round(cost - o.cost);
    }
}
