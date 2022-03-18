package jdevhl.util;

import jdevhl.lang.EasyObject;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * Utility class for use of Lists.
 *
 * @author Oscar Montes
 * @see java.util.List
 * @since 1.0.0
 */
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

    public static List<?> sort(List<?> list) {
        if (isEmpty(list)) {
            return list;
        }
        checkListComparableValues(list);
        return list.stream().sorted().collect(Collectors.toList());
    }

    public static String getBiggestString(List<String> list) {
        if (isEmpty(list)) {
            return null;
        }
        return list.stream().max(comparing(String::length)).get();
    }

    public static Integer getBiggestInteger(List<Integer> list) {
        if (isEmpty(list)) {
            return null;
        }
        return list.stream().max(comparing(Integer::intValue)).get();
    }

    private static void checkListComparableValues(List<?> list) {
        final Object value = getFirst(list);
        if (!EasyObject.isComparable(value)) {
            throw new IllegalArgumentException("Key must be Comparable");
        }
    }
}
