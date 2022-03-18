package jdevhl.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EasyDateTest {


    @Test
    public void fromStringAllTest() throws ParseException {
        Date date1 = EasyDate.fromString("2020-08-27", EasyDate.HYPHEN_YYYY_MM_DD, Locale.ENGLISH);
        Date date2 = EasyDate.fromString("27-08-2020", EasyDate.HYPHEN_DD_MM_YYYY, Locale.ENGLISH);
        assertEquals(date1, date2);
        Date date3 = EasyDate.fromString("27/08/2020", EasyDate.SLASH_DD_MM_YYYY, Locale.ENGLISH);
        assertEquals(date2, date3);
    }

    @Test
    public void fromStringWithFormater() throws ParseException {
        Date date1 = EasyDate.fromString("2020-08-27", EasyDate.HYPHEN_YYYY_MM_DD);
        Date date2 = EasyDate.fromString("27-08-2020", EasyDate.HYPHEN_DD_MM_YYYY);
        assertEquals(date1, date2);
        Date date3 = EasyDate.fromString("27/08/2020", EasyDate.SLASH_DD_MM_YYYY);
        assertEquals(date2, date3);
    }

    @Test
    public void fromStringTest() throws ParseException {
        Date date1 = EasyDate.fromString("2020-08-27");
        Date date2 = EasyDate.fromString("27-08-2020");
        assertEquals(date1, date2);
        Date date3 = EasyDate.fromString("27/08/2020");
        assertEquals(date2, date3);
    }

    @Test
    public void fromStringException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            EasyDate.fromString("01--02--0003");
        });

    }

}