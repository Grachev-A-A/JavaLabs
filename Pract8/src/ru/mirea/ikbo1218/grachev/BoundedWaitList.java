package ru.mirea.ikbo1218.grachev;

import java.util.Collection;

/**
 * Class of queue with constant max {@link BoundedWaitList#capacity}.
 * @param <E> Type of stored data.
 * @see IWaitList
 * @see WaitList
 * @author aleksandrgracev
 * @version 1.2
 */
public class BoundedWaitList <E> extends WaitList<E> {

    /**
     * Field for maximum capacity of the queue.
     */
    private int capacity;

    /**
     * Constructor - creating new object without any data and with maximum capacity.
     * @param capacity Maximum {@link BoundedWaitList#capacity} of queue.
     * @see WaitList#WaitList()
     * @throws IllegalArgumentException Maximum capacity equal or below zero.
     */
    public BoundedWaitList(int capacity){
        super();
        if(capacity <= 0) throw new IllegalArgumentException("Максимальный размер должен быть больше 0! Получено значение: " + capacity);
        this.capacity = capacity;
    }


    /**
     * Overrides constructor of copies from superclass to set max capacity equal to collection's size.
     * @param col Collection to copy from
     * @see WaitList#WaitList(Collection)
     * @since 1.2
     */
    public BoundedWaitList(Collection<E> col){
        super(col);
        this.capacity = col.size();
    }

    /**
     * Method to get property {@link BoundedWaitList#capacity}
     * @return Value of {@link BoundedWaitList#capacity}
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Method to add element into queue (at end).
     * @param element Value to be added.
     * @throws IllegalStateException Queue is full: reached maximum {@link BoundedWaitList#capacity}
     * @see WaitList#add(Object)
     */
    @Override
    public void add(E element) {
        if(components.size() == capacity) throw new IllegalStateException("Очередь заполнена!");
        components.add(element);
    }

    /**
     * Method to get information about this list in String type.
     * @return String-value of this list.
     */
    @Override
    public String toString() {
        return "BoundedWaitList{" +
                "capacity=" + capacity +
                ", components=" + components +
                '}';
    }
}
