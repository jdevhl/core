package com.github.jdevhl.helper.lists;

import java.util.List;

import static java.util.Comparator.comparing;

public class ListHelper {

    public static String getTheBiggestSizeString(List<String> list) {
        return list.stream().max(comparing(String::length)).get();
    }
}
