package ru.mirea.ikbo1218.grachev;

public abstract class Furniture {
    private int legCount;
    private double height;
    private double width;
    private double depth;
    private boolean maySeat;
    private int price;
    private String modelName;

    public Furniture(int legCount, double height, double width, double depth, boolean maySeat, int price, String modelName) {
        this.legCount = legCount;
        if(height <= 0)
            throw new IllegalArgumentException("Высота должна быть больше 0!");
        this.height = height;
        if(width <= 0)
            throw new IllegalArgumentException("Ширина должна быть больше 0!");
        this.width = width;
        if(depth <= 0)
            throw new IllegalArgumentException("Глубина должна быть больше 0!");
        this.depth = depth;
        this.maySeat = maySeat;
        this.price = price;
        this.modelName = modelName;
    }

    public abstract void jumpOn();

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setHeight(int height) {
        if(height <= 0)
            throw new IllegalArgumentException("Высота должна быть больше 0!");
        this.height = height;
    }

    public void setWidth(int width) {
        if(width <= 0)
            throw new IllegalArgumentException("Ширина должна быть больше 0!");
        this.width = width;
    }

    public void setDepth(int depth) {
        if(depth <= 0)
            throw new IllegalArgumentException("Глубина должна быть больше 0!");
        this.depth = depth;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }

    public int getLegCount() {
        return legCount;
    }

    public boolean isMaySeat() {
        return maySeat;
    }

    @Override
    public String toString() {
        return "modelName=" + modelName +
                ", legCount=" + legCount +
                ", height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                ", maySeat=" + maySeat +
                ", price=" + price;
    }
}
