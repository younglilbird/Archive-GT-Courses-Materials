/**
 * List Abstract Data Type.
 * @author CS1331 TAs
 * @version 1.0
 * @param <E> type of elements the list contains
 */
public interface List<E> {

    /**
     * Inserts the element at the specified index.
     * @param index index to add the element
     * @param element data we are adding to the list
     */
    void add(int index, E element);

    /**
     * Removes the specified element from the list and returns it.
     * @param element data to be removed
     * @return the removed element from the list
     */
    boolean remove(E element);

    /**
     * Removes the element at the specified index and returns it.
     * @param index index of element to be removed
     * @return the removed element at the specified index
     */
    E remove(int index);

    /**
     * Returns the element at the specified index.
     * @param index index of the element to return
     * @return element at the specified index
     */
    E get(int index);

    /**
     * Checks if a list contains a specific element.
     * @param element data to check for in list
     * @return boolean representing if list has element or not
     */
    boolean contains(E element);

    /**
     * Replaces the element at a specific index with the passed in data.
     * @param index index of the element to replace
     * @param element the element to set
     * @return element that has been replaced
     */
    E set(int index, E element);

    /**
     * Clears the list.
     */
    void clear();

    /**
     * Checks if the list is empty.
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the list.
     * @return int representing size of list
     */
    int size();
}
