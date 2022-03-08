package com.github.jdevhl.lang;

public class EasyString {

    private static final String REGEX_STRING_NUMBER = "\\d+";

    public static boolean isEmpty(String value) {
        if (value == null) {
            return true;
        }
        return value.length() == 0;
    }

    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    public static boolean isNumber(String value) {
        if (value == null) {
            return false;
        }
        return value.matches(REGEX_STRING_NUMBER);
    }
}
