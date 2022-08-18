package jdevhl.lang;


import java.util.Objects;

/**
 * Utility class for use of Integer.
 *
 * @author Oscar Montes
 * @see java.lang.Integer
 * @since 1.0.0
 */
public class EasyInteger {

    public static Integer getValue(String value) {
        Integer intValue = null;
        if (Objects.nonNull(value)) {
            intValue = Integer.valueOf(value);
        }
        return intValue;
    }

    public static Integer getSafetyValue(String value) {
        Integer intValue = null;
        try {
            intValue = getValue(value);
        } catch (NumberFormatException e) {

        }
        return intValue;
    }
}
