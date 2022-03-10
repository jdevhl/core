package jdevhl.math;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EasyBigDecimalTest {

    @Test
    public void valueOfStringTest() {
        assertEquals(BigDecimal.ONE, EasyBigDecimal.valueOf("1"));
        assertEquals(BigDecimal.valueOf(1.2), EasyBigDecimal.valueOf("1.2"));
    }

    @Test
    public void valueOfIntegerTest() {
        assertEquals(BigDecimal.ONE, EasyBigDecimal.valueOf(1));
        assertEquals(BigDecimal.valueOf(100), EasyBigDecimal.valueOf(100));
    }

}