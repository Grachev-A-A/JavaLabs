package ru.mirea.ikbo1218.grachev;

import java.util.Comparator;

public class StudentComp implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if(!(o1 instanceof Student && o2 instanceof Student))
            throw new IllegalArgumentException("Объекты не являются студентами!");

        return ((Student) o1).getGPA() - ((Student) o2).getGPA();
    }
}
