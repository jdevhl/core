package com.github.jdevhl.util;

import java.util.List;

import static java.util.Comparator.comparing;

public class EasyList {

    public static boolean isEmpty(List<?> list) {
        if (list == null) {
            return true;
        }
        return list.size() == 0;
    }

    public static boolean isNotEmpty(List<?> list) {
        return !isEmpty(list);
    }

    public static <T> T getFirst(List<T> list) {
        return list.stream().findFirst().get();
    }

    public static <T> T getLast(List<T> list) {
        return list.stream().reduce((first, second) -> second)
                .orElse(null);
    }

    public static String getBiggestString(List<String> list) {
        return list.stream().max(comparing(String::length)).get();
    }

    public static Integer getBiggestInteger(List<Integer> list) {
        return list.stream().max(comparing(Integer::intValue)).get();
    }
}
