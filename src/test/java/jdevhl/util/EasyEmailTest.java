package jdevhl.util;

import jdevhl.util.EasyEmail;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EasyEmailTest {

    @Test
    public void isValidTest() {
        assertTrue(EasyEmail.isValid("email@valid.com"));
        assertFalse(EasyEmail.isValid("email@@valid.com"));
        assertFalse(EasyEmail.isValid("email"));
        assertFalse(EasyEmail.isValid("email@notvalid"));
    }
}