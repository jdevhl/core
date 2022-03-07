package com.github.jdevhl.util.string;

public class EasyString {

    public static boolean isEmpty(String value) {
        if (value == null) {
            return true;
        }
        return value.length() == 0;
    }

    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }
}
