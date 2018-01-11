/**
 * The purpose of this class is to implement a Linked List ADT.
 * 
 * @author John Sweet
 * @version 20161023
 *
 */

public class LListCNU {

    private Link head;
    private Link curr;
    private Link tail;
    private int size;

    /**
     * Creates an empty list
     */
    public LListCNU() {
        erase();
    }

    /**
     * Returns the size of the linked list
     * 
     * @return size the length of the list
     */
    public java.lang.Integer size() {
        return size;
    }

    /**
     * Inserts object at the current position
     * 
     * @param o
     *            object received
     */
    public void insert(java.lang.Object o) {
        curr.setNext(new Link(curr.element(), curr.next()));
        curr.setElement(o);
        if (curr == tail) {
            tail = curr.next();
        }
        size++;
    }

    /**
     * Removes element at the current position
     * 
     * @throws java.lang.IllegalStateException
     */
    public void remove() throws java.lang.IllegalStateException {
        if (curr == tail) {
            throw new IllegalStateException();
        }
        curr.setElement(new Link(curr.element(), curr.next()));
        if (curr.next() != tail) {
            curr.setNext(curr.next().next());
        }
        else {
            curr = tail;
        }
        size--;
    }

    /**
     * Returns the value of the current element
     * 
     * @return current element's value
     * @throws java.lang.IllegalStateException
     */
    public java.lang.Object get() throws java.lang.IllegalStateException {
        if (curr.element() == null) {
            throw new IllegalStateException();
        }
        return curr.element();
    }

    /**
     * Erases all elements in the list
     */
    public void erase() {
        tail = new Link(null);
        curr = tail;
        head = new Link(tail);
        size = 0;
    }

    /**
     * Goes to next element in the linked list
     */
    public void next() {
        if (curr != tail) {
            curr = curr.next();
        }
    }

    /**
     * Goes to previous element in the linked list
     */
    public void prev() {
        if (curr == head.next()) {
            return;
        }
        Link temp = head;
        while (temp.next() != curr) {
            temp = temp.next();
        }
        curr = temp;
    }

    /**
     * Returns the current position of the current element
     * 
     * @return current position
     */
    public java.lang.Integer curPos() {
        Link temp = head.next();
        int i = 0;
        while (temp != curr) {
            temp = temp.next();
            i++;
        }
        return i;
    }

    /**
     * Moves the cursor to the first element
     */
    public void moveToFirst() {
        curr = head.next();
    }

    /**
     * Returns the list in the form of a string with the elements inside "< >"
     * separated by commas. The cursor is shown as "|" to the left of the
     * current element
     * 
     * @return the list in the form of a string
     */
    public java.lang.String asString() {
        String str = "";
        Link temp = head.next();
        while (temp != tail) {
            if (temp == curr) {
                if (curr.next() == null) {
                    str = str + " | ";
                }
                else {
                    str = str + " | " + temp.element();
                }
            }
            else if (temp.next() != null) {
                if (temp == head.next()) {
                    str = str + " " + temp.element();
                }
                else {
                    str = str + " , " + temp.element();
                }
            }
            else {
                str = str + temp.element();
            }
            temp = temp.next();
        }
        str = "<" + str;
        str = str.substring(0, str.length());
        if (curr.next() == null) {
            str = str + " | >";
        }
        else {
            str = str + " >";
        }
        return str;
    }

    /**
     * Determines if the list contains the given object. Returns its position if
     * it is in the list and -1 if it is not in the list.
     * 
     * @param o
     *            object received
     * @return position of object if it is in the list
     */
    public java.lang.Integer contains(java.lang.Object o) {
        Link temp = head.next();
        try {
            while (temp.element() != o) {
                temp = temp.next();
            }
            curr = temp;
            return curPos();
        }
        catch (NullPointerException e) {
            return -1;
        }
    }
}
