/**
 * Stack Abstract Data Type.
 * @author CS1331 TAs
 * @version 1.0
 * @param <E> type of elements the list contains
 */
public interface Stack<E> {

    /**
     * Looks at the element on the top of the stack but
     * does not remove it.
     * @return element at the top of the stack
     */
    E peek();

    /**
     * Removes the element at the top of the stack and returns it.
     * @return element at the top of the stack
     */
    E pop();


    /**
     * Adds the passed in element to the stop of the stack.
     * @param element the element to be pushed onto the stack
     * @return element that was added
     */
    E push(E element);

}
