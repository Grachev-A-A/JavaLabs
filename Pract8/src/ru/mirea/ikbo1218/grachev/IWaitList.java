package ru.mirea.ikbo1218.grachev;

import java.util.Collection;

/**
 * Interface IWaitList with methods for implementors.
 * @param <E> Type of elements to store in WaitList.
 * @author aleksandrgracev
 *  * @version 1.0
 */
public interface IWaitList <E> {
    /**
     * Method to add element into end of queue.
     * @param element Value to be added.
     */
    void add(E element);

    /**
     * Method to remove first element of queue.
     * @return Removed element.
     */
    E remove();

    /**
     * Method to check, is equal element included in queue or not.
     * @param element Value for search.
     * @return Is <i>(true)</i> element in list or not <i>(false)</i>.
     */
    boolean contains(E element);

    /**
     * Method to check, are all elements of collection included in queue or not.
     * @param collection Collection with values for search.
     * @return Are <i>(true)</i> all elements in list or not <i>(false)</i>.
     */
    boolean containsAll(Collection<E> collection);

    /**
     * Method to check, are there any elements in list or not.
     * @return True - no elements, false - any elements in list.
     */
    boolean isEmpty();
}
