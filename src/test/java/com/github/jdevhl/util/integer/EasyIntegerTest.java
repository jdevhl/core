package com.github.jdevhl.util.integer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EasyIntegerTest {

    @Test
    public void getIntegerValueTest() {
        Integer value = EasyInteger.getValue("123456");
        assertEquals(123456, value);
    }

    @Test
    public void getIntegerSafetyValueTest() {
        Integer value = EasyInteger.getSafetyValue("123456789");
        assertEquals(123456789, value);
    }

    @Test
    public void getIntegerSafetyValueFailTest() {
        Integer value = EasyInteger.getSafetyValue("123456789a");
        assertNull(value);
    }

}