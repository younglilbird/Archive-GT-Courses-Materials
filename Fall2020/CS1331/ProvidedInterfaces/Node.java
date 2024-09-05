//I worked on the homework assignment alone, using only course materials.
/**
 * Node class that contains the linkedlist consist of nodes.
 * @author Yulong Liang
 * @version 1.0
 * @param <E> the generic sign for the node class.
 */
public class Node<E> {
    private E data;
    private Node<E> next;
    /**
     *construct a node with data and next.
     *@param data the node's own data.
     *@param next the next node.
     */
    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }
    /**
     *construct a node with only data.
     *@param data the node's own data.
     */
    public Node(E data) {
        this.data = data;
        this.next = null;
    }
    /**
     *getter for data.
     *@return the node's own data.
     */
    public E getData() {
        return this.data;
    }
    /**
     *setter for data.
     *@param data the node's own data.
     */
    public void setData(E data) {
        this.data = data;
    }
    /**
     *getter for next.
     *@return the next node.
     */
    public Node<E> getNext() {
        return this.next;
    }
    /**
     *setter for next.
     *@param next the next node.
     */
    public void setNext(Node next) {
        this.next = next;
    }
}