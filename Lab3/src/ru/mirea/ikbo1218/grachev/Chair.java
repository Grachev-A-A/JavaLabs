package ru.mirea.ikbo1218.grachev;

public class Chair extends Furniture {

    private String backseatMaterial, mainMaterial;
    private boolean isCircle;

    public Chair(String modelName, double height, double width, double depth, String backseatMaterial, String mainMaterial, boolean isCircle, int price) {
        super(4, height, width, depth, true, price, modelName);
        this.backseatMaterial = backseatMaterial;
        this.mainMaterial = mainMaterial;
        this.isCircle = isCircle;
    }

    public String getBackseatMaterial() {
        return backseatMaterial;
    }

    public void setBackseatMaterial(String backseatMaterial) {
        this.backseatMaterial = backseatMaterial;
    }

    public String getMainMaterial() {
        return mainMaterial;
    }

    public void setMainMaterial(String mainMaterial) {
        this.mainMaterial = mainMaterial;
    }

    public boolean isCircle() {
        return isCircle;
    }

    public void setCircle(boolean circle) {
        isCircle = circle;
    }

    @Override
    public void jumpOn() {
        System.out.println("Ouch! Стул сломался, когда вы попытались на нём прыгать!");
    }

    @Override
    public String toString() {
        return "Chair{" +
                "backseatMaterial='" + backseatMaterial + '\'' +
                ", mainMaterial='" + mainMaterial + '\'' +
                ", isCircle=" + isCircle +
                ", " + super.toString() +
                '}';
    }
}
