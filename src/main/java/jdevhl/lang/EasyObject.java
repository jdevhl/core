package jdevhl.lang;

/**
 * Utility class for use of Object.
 *
 * @author Oscar Montes
 * @see java.lang.Object
 * @since 1.0.0
 */
public class EasyObject {

    public static boolean isComparable(Object object) {
        return object instanceof Comparable;
    }

    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean isNonNull(Object object) {
        return !isNull(object);
    }
}
