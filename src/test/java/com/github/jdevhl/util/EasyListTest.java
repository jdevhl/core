package com.github.jdevhl.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EasyListTest {

    @Test
    public void isEmptyTest() {
        assertEquals(true, EasyList.isEmpty(new ArrayList<>()));
        assertEquals(true, EasyList.isEmpty(null));
        assertEquals(false, EasyList.isEmpty(List.of("list")));
    }

    @Test
    public void isNotEmptyTest() {
        assertEquals(false, EasyList.isNotEmpty(new ArrayList<>()));
        assertEquals(false, EasyList.isNotEmpty(null));
        assertEquals(true, EasyList.isNotEmpty(List.of("list")));
    }

    @Test
    public void getFistTest() {
        List<String> list = List.of("first", "second", "third");
        assertEquals("first", EasyList.getFirst(list));
    }

    @Test
    public void getLastTest() {
        List<String> list = List.of("first", "second", "third");
        assertEquals("third", EasyList.getLast(list));
    }

    @Test
    public void getBiggestStringTest() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        assertEquals("three", EasyList.getBiggestString(list));
    }

    @Test
    public void getBiggestIntegerTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(10);
        list.add(3);
        list.add(9);
        assertEquals(10, EasyList.getBiggestInteger(list));
    }
}