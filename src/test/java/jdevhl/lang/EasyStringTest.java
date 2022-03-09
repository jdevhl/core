package jdevhl.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EasyStringTest {

    @Test
    public void isEmptyTest() {
        assertEquals(true, EasyString.isEmpty(null));
        assertEquals(true, EasyString.isEmpty(""));
        assertEquals(true, EasyString.isEmpty("   "));
        assertEquals(false, EasyString.isEmpty("not Empty"));
    }

    @Test
    public void isNotEmptyTest() {
        assertEquals(false, EasyString.isNotEmpty(null));
        assertEquals(false, EasyString.isNotEmpty(""));
        assertEquals(true, EasyString.isNotEmpty("not Empty"));
    }

    @Test
    public void isNumberTest() {
        assertEquals(true, EasyString.isNumber("1"));
        assertEquals(false, EasyString.isNumber("1a"));
    }
}