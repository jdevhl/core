package jdevhl.lang;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 * Utility class for use of String.
 *
 * @author Oscar Montes
 * @see java.lang.String
 * @since 1.0.0
 */
public class EasyString {

    private static final String REGEX_STRING_NUMBER = "\\d+";
    public static final String REMOVE_POINT_COMMA = "[\\.\\,]";

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
        value = value.replaceFirst(REMOVE_POINT_COMMA, "");
        return value.matches(REGEX_STRING_NUMBER);
    }

    public static String normalize(String value) {
        String wordNormalized = Normalizer.normalize(value, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(wordNormalized).replaceAll("");
    }
}
