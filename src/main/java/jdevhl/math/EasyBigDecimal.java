package jdevhl.math;

import jdevhl.lang.EasyString;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Utility class for use of CSV Files.
 *
 * @author Oscar Montes
 * @since 1.0.0
 */
public class EasyBigDecimal {

    private static final Integer VALUES_SCALE = 3;

    public static BigDecimal valueOf(String value) {
        if (EasyString.isEmpty(value)) {
            return null;
        }
        if (!EasyString.isNumber(value)) {
            throw new NumberFormatException("The value " + value + " is not a number");
        }
        if (EasyString.isDecimalNumber(value)) {
            return BigDecimal.valueOf(Double.valueOf(value));
        }
        return BigDecimal.valueOf(Long.valueOf(value));
    }

    public static BigDecimal valueOf(Integer value) {
        if (value == null) {
            return null;
        }
        return BigDecimal.valueOf(Long.valueOf(value));
    }

    public static BigDecimal roundUpHalfUp(BigDecimal value) {
        return value.setScale(VALUES_SCALE, RoundingMode.HALF_UP);
    }

    public static BigDecimal roundUpHalfDown(BigDecimal value) {
        return value.setScale(VALUES_SCALE, RoundingMode.HALF_DOWN);
    }
}
