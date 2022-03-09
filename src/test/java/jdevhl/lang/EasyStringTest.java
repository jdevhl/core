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
    public void lowerCaseTest() {
        String upperString = "HELLO this is a UPPER String";
        assertEquals("hello this is a upper string", EasyString.lowerCase(upperString));
    }

    @Test
    public void firstUpperCaseTest() {
        String upperString = "HELLO";
        assertEquals("Hello", EasyString.firstUpperCase(upperString));

        String upperString2 = "h";
        assertEquals("H", EasyString.firstUpperCase(upperString2));

        String upperString3 = "he";
        assertEquals("He", EasyString.firstUpperCase(upperString3));
    }

    @Test
    public void isNumberTest() {
        assertEquals(true, EasyString.isNumber("1"));
        assertEquals(false, EasyString.isNumber("1a"));
    }
}