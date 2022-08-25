package jdevhl.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArraysTest {

    @Test
    public void asListTest(){
        String[] names = {"irene","oscar", "juan", "ivan"};

        List<String> namesList = Arrays.asList(names);

        assertEquals(names.length, namesList.size());

        names[0] = "maite";

        assertEquals("irene", namesList.get(0));
        assertEquals("maite", names[0]);
    }

    @Test
    public void asListNullPointerTest(){
        assertThrows(NullPointerException.class, () -> {
            Arrays.asList(null);
        });
    }
}