//I worked on the homework assignment alone, using only course materials.
/**
 * Linkedlist generic class that contains A Singly-LinkedList of Nodes.
 *
 * @param <E> the generic sign for the class.
 * @author Yulong Liang
 * @version 1.0
 */
public class LinkedList<E> implements List<E>, Stack<E> {
    private Node<E> head;
    /**
     *construct with no-args.
     */
    public LinkedList() {
        this.head = null;
    }
    /**
     *getter for head.
     *@return the head of list.
     */
    public Node getHead() {
        return this.head;
    }

    @Override
    public void add(int indexToInsert, E data) throws IllegalArgumentException, NullPointerException {
        if (indexToInsert < 0 || indexToInsert > this.size()) {
            throw new IllegalArgumentException("Your index is invalid");
        } else if (data == null) {
            throw new NullPointerException("Cannot add null data to list");
        } else {
            if (this.head == null) {
                // if uninitialized
                this.head = new Node<>(data);
            } else if (indexToInsert == 0) {
                // insert at head
                Node<E> oldHead = this.head;
                this.head = new Node<>(data);
                this.head.setNext(oldHead);
            } else {
                Node<E> currNode = head;
                int currIdx = 0;
                while (currIdx != indexToInsert - 1) {
                    currNode = currNode.getNext();
                    currIdx++;
                }
                // insert data after currNode
                // i.e. currNode->Node(data)->currNext
                Node<E> currNext = currNode.getNext();
                Node<E> nodeToInsert = new Node<>(data);
                currNode.setNext(nodeToInsert);
                nodeToInsert.setNext(currNext);
            }
        }
    }

    @Override
    public boolean remove(E element) {
        if (this.head == null) {
            // if no elements
            return false;
        } else {
            // edge case for removing head
            if (this.head.getData().equals(element)) {
                // pop head; size--; head = head->next
                Node<E> toRemove = this.head;
                this.head = this.head.getNext();
                return true;
            }
            // general case
            Node<E> currNode = this.head;
            Node<E> prevNode = null;
            while (currNode != null) {
                if (currNode.getData().equals(element)) {
                    // pop currNode; size--; prevNode -> currNode.next
                    //assert prevNode != null;
                    prevNode.setNext(currNode.getNext());
                    return true;
                } else {
                    // not found yet; update currNode && prevNode
                    prevNode = currNode;
                    currNode = currNode.getNext();
                }
            }
            // remove failed
            return false;
        }
    }

    @Override
    public E remove(int indexToRemove) throws IllegalArgumentException {
        if (indexToRemove < 0 || indexToRemove >= this.size()) {
            throw new IllegalArgumentException("Your index is invalid");
        } else {
            if (this.head == null) {
                // if no elements
                return null;
            } else {
                // edge case for removing head
                if (indexToRemove == 0) {
                    // pop head; size--; head = head->next
                    Node<E> toRemove = this.head;
                    this.head = this.head.getNext();
                    return toRemove.getData();
                }
                // general case
                Node<E> currNode = this.head;
                Node<E> prevNode = null;
                int currIndex = 0;
                while (currNode != null) {
                    if (indexToRemove == currIndex) {
                        // pop currNode; size--; prevNode -> currNode.next
                        prevNode.setNext(currNode.getNext());
                        return currNode.getData();
                    } else {
                        // not found yet; update currNode && prevNode
                        prevNode = currNode;
                        currNode = currNode.getNext();
                        currIndex++;
                    }
                }
                // remove failed
                return null;
            }
        }
    }

    @Override
    public E get(int index) throws IllegalArgumentException {
        if (index < 0 || index >= this.size()) {
            throw new IllegalArgumentException("Your index is invalid");
        } else {
            int currIdx = 0;
            Node<E> currNode = this.head;
            while (index != currIdx) {
                currNode = currNode.getNext();
                currIdx++;
            }
            return currNode.getData();
        }
    }

    @Override
    public E set(int index, E element) throws IllegalArgumentException, NullPointerException {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("Your index is invalid");
        } else if (element == null) {
            throw new NullPointerException("Cannot add null data to list");
        } else {
            Node t = head;
            for (int i = 0; i < index; i++) {
                t = t.getNext();
            }
            E result = (E) t.getData();
            t.setData(element);
            return result;
        }
    }

    @Override
    public boolean contains(E element) throws NullPointerException {
        Node t = head;
        if (this.head == null) {
            return false;
        } else if (element == null) {
            throw new NullPointerException("Null data cannot be in list");
        } else {
            if (t.getData().equals(element)) {
                return true;
            }
            while (t.getNext() != null) {
                if (t.getNext().getData().equals(element)) {
                    return true;
                }
                t = t.getNext();
            }
            return false;
        }
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public int size() {
        int theSize = 0;
        Node<E> currNode = this.head;
        while (currNode != null) {
            theSize++;
            currNode = currNode.getNext();
        }
        return theSize;
    }

    @Override
    public E push(E element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException("Cannot add null data to stack");
        }
        Node a = new Node(element, head);
        head = a;
        return element;
    }

    @Override
    public E pop() throws IllegalArgumentException {
        if (head == null) {
            throw new IllegalArgumentException("Empty stack");
        }
        E result = head.getData();
        head = head.getNext();
        return result;
    }

    @Override
    public E peek() throws IllegalArgumentException {
        if (head == null) {
            throw new IllegalArgumentException("Empty stack");
        }
        return head.getData();
    }
}