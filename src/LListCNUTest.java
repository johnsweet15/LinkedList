import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class contains the test methods for the LListCNU class
 * 
 * @author John Sweet
 * @version 10032016
 * 
 */

public class LListCNUTest {

    /**
     * Does size() return the correct size of the linked list
     */
    @Test
    public void doesSizeReturnTheSizeOfTheList() {
        LListCNU list = new LListCNU();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        assertEquals(3, (Object) list.size());
    }

    /**
     * Does insert() correctly add an object at the current position
     */
    @Test
    public void doesInsertAddObjectAtCurrentPosition() {
        LListCNU list = new LListCNU();
        list.insert(1);
        assertEquals(1, list.get());
        list.insert(2);
        assertEquals(2, list.get());
        list.insert(3);
        assertEquals(3, list.get());
    }

    /**
     * Does the remove method remove the current element
     */
    @Test
    public void doesRemoveGetRidOfCurrentElement() {
        LListCNU list = new LListCNU();
        list.insert(1);
        list.next();
        list.insert(2);
        list.next();
        list.insert(3);
        list.remove();

        assertEquals(2, (Object) list.size());
        assertEquals(-1, (Object) list.contains(3));
    }

    /**
     * Does remove() throw in Illegal State Exception if the cursor is not at a
     * list element
     */
    @Test(expected = IllegalStateException.class)
    public void doesRemoveThrowISEIfCursorIsNotAtListElement() {
        LListCNU list = new LListCNU();
        list.remove();
        assertEquals(0, list.get());
    }

    /**
     * Does get() return the value of the current element
     */
    @Test
    public void doesGetReturnCurrentElementsValue() {
        LListCNU list = new LListCNU();
        list.insert(1);
        assertEquals(1, list.get());
    }

    /**
     * Does get() throw an Illegal State Exception if the cursor is not at list
     * element
     */
    @Test(expected = IllegalStateException.class)
    public void doesGetThrowISEIfCursorIsNotAtListElement() {
        LListCNU list = new LListCNU();
        list.get();
        assertEquals(0, list.get());
    }

    /**
     * Does erase empty the entire list
     */
    @Test
    public void doesEraseClearTheEntireListOfAllElements() {
        LListCNU list = new LListCNU();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.erase();
        assertEquals(0, (Object) list.size());
    }

    /**
     * Does next() set the cursor to the next position
     */
    @Test
    public void doesNextSetCursorToNextPosition() {
        LListCNU list = new LListCNU();
        list.insert(1);
        list.next();
        list.insert(2);
        list.next();
        list.insert(3);

        assertEquals(2, (Object) list.curPos());

        list.next();
        assertEquals(3, (Object) list.curPos());
    }

    /**
     * Does prev() set the cursor to the previous position
     */
    @Test
    public void doesPrevSetCursorToPrevPosition() {
        LListCNU list = new LListCNU();
        list.insert(1);
        list.next();
        list.insert(2);
        list.next();
        list.insert(3);
        list.prev();

        assertEquals(1, (Object) list.curPos());
    }

    /**
     * Does curPos() return the position of the current element
     */
    @Test
    public void doesCurPosReturnPositionOfCurrentElement() {
        LListCNU list = new LListCNU();
        list.insert(1);
        list.next();
        list.insert(2);
        list.next();
        list.insert(3);

        assertEquals(2, (Object) list.curPos());
    }

    /**
     * Does moveToFirst() move the cursor to the beginning of the list
     */
    @Test
    public void doesMoveToFirstMoveCursorToFirstElement() {
        LListCNU list = new LListCNU();
        list.insert(1);
        list.next();
        list.insert(2);
        list.moveToFirst();
        assertEquals(0, (Object) list.curPos());
    }

    /**
     * Does asString() convert the list to the correctly formatted string when
     * curr is the first element
     */
    @Test
    public void doesAsStringConvertAListToFormattedStringWhenCurrIsFirst() {
        LListCNU list = new LListCNU();
        list.insert(1);
        list.insert(2);
        list.insert(3);

        assertEquals("< | 3 , 2 , 1 >", list.asString());
    }

    /**
     * Does asString() convert the list to the correctly formatted string when
     * curr is one of the middle elements
     */
    @Test
    public void doesAsStringConvertAListToFormattedStringWhenCurrIsMiddle() {
        LListCNU list = new LListCNU();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.next();

        assertEquals("< 3 | 2 , 1 >", list.asString());
    }

    /**
     * Does asString() convert the list to the correctly formatted string when
     * curr is the last element
     */
    @Test
    public void doesAsStringConvertAListToFormattedStringWhenCurrIsLast() {
        LListCNU list = new LListCNU();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.next();
        list.next();
        list.next();

        assertEquals("< 3 , 2 , 1 | >", list.asString());
    }

    /**
     * Does asString() convert the list to the correctly formatted string when
     * the list is empty
     */
    @Test
    public void doesAsStringConvertAListToFormattedStringWhenListIsEmpty() {
        LListCNU list = new LListCNU();

        assertEquals("< | >", list.asString());
    }

    /**
     * Does contains() correctly determine if an object is in the list and
     * returns its position
     */
    @Test
    public void doesContainsDetermineIfAnObjectIsInTheList() {
        LListCNU list = new LListCNU();
        list.insert(1);
        list.next();
        list.insert(2);
        list.next();
        list.insert(3);

        assertEquals(0, (Object) list.contains(1));
        assertEquals(1, (Object) list.contains(2));
        assertEquals(2, (Object) list.contains(3));
        assertEquals(-1, (Object) list.contains(4));
    }
}
