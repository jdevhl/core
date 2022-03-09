package jdevhl.lang;

public class EasyString {

    private static final String REGEX_STRING_NUMBER = "\\d+";

    public static boolean isEmpty(String value) {
        if (value == null) {
            return true;
        }
        return value.trim().length() == 0;
    }

    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    public static String lowerCase(String value) {
        if (!isEmpty(value)) {
            return value.toLowerCase();
        } else {
            return value;
        }
    }

    public static String firstUpperCase(String value) {
        if (!isEmpty(value)) {
            String valueLC = lowerCase(value);
            String firstLetter = valueLC.substring(0, 1).toUpperCase();
            int valueLength = valueLC.length();
            if (valueLength > 1) {
                return firstLetter.concat(valueLC.substring(1, valueLength));
            } else {
                return firstLetter;
            }
        } else {
            return value;
        }
    }

    public static boolean isNumber(String value) {
        if (isEmpty(value)) {
            return false;
        }
        return value.matches(REGEX_STRING_NUMBER);
    }
}
