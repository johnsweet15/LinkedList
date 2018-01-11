
/**
 * The link class creates Link nodes that make up link lists
 * 
 * @author John Sweet
 * @version 20161023
 *
 */

public class Link {

    private Object o;
    private Link n;

    /**
     * Creates a new Link
     * 
     * @param it
     *            the object received
     * @param inn
     *            the link received
     */
    Link(Object it, Link inn) {
        o = it;
        n = inn;
    }

    /**
     * Creates a new link
     * 
     * @param inn
     *            the link received
     */
    Link(Link inn) {
        n = inn;
    }

    /**
     * Return the node's element
     * 
     * @return o the element
     */
    Object element() {
        return o;
    }

    /**
     * Sets element to a new object
     * 
     * @param it
     *            the object received
     * @return o the object
     */
    Object setElement(Object it) {
        o = it;
        return o;
    }

    /**
     * Returns the next element
     * 
     * @return n the next element
     */
    Link next() {
        return n;
    }

    /**
     * Sets link to a new link
     * 
     * @param inn
     *            the Link received
     * @return the new Link
     */
    Link setNext(Link inn) {
        n = inn;
        return n;
    }
}
