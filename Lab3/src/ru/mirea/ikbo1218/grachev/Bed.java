package ru.mirea.ikbo1218.grachev;

public class Bed extends Furniture {
    private int personCount, maxWeight;
    private String mainMaterial, mattressMaterial;

    public Bed(String modelName, double height, double width, double depth, int price,
               int personCount, int maxWeight, String mainMaterial, String mattressMaterial) {
        super(4, height, width, depth, true, price, modelName);
        if(personCount <= 0 || personCount >=4)
            throw new IllegalArgumentException("Невозможное число спальных мест для кровати: " + personCount);
        this.personCount = personCount;
        this.maxWeight = maxWeight;
        this.mainMaterial = mainMaterial;
        this.mattressMaterial = mattressMaterial;
    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public String getMainMaterial() {
        return mainMaterial;
    }

    public void setMainMaterial(String mainMaterial) {
        this.mainMaterial = mainMaterial;
    }

    public String getMattressMaterial() {
        return mattressMaterial;
    }

    public void setMattressMaterial(String mattressMaterial) {
        this.mattressMaterial = mattressMaterial;
    }

    @Override
    public void jumpOn() {
        System.out.println("Прыгать на кровати весело! Но долго ли она выдержит?");
    }

    @Override
    public String toString() {
        return "Bed{" +
                "personCount=" + personCount +
                ", maxWeight=" + maxWeight +
                ", mainMaterial='" + mainMaterial + '\'' +
                ", mattressMaterial='" + mattressMaterial + '\'' +
                ", " + super.toString() +
                '}';
    }
}
