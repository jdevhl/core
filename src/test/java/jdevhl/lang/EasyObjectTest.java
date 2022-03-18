package jdevhl.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EasyObjectTest {

    @Test
    public void isComparableTest() {
        assertEquals(false, EasyObject.isComparable(null));
        assertEquals(true, EasyObject.isComparable("hello"));
    }

    @Test
    public void isNullTest() {
        assertEquals(true, EasyObject.isNull(null));
        assertEquals(false, EasyObject.isNull("hello"));
    }

    @Test
    public void isNonNullTest() {
        assertEquals(false, EasyObject.isNonNull(null));
        assertEquals(true, EasyObject.isNonNull("hello"));
    }
}