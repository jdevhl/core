package com.github.jdevhl.lists;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListHelperTest {

    @Test
    public void getTheBiggestSizeStringTest() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        assertEquals("three", ListHelper.getTheBiggestSizeString(list));
    }
}