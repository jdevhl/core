package jdevhl.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Utility class for use of lists
 *
 * @author Oscar Montes
 * @since 1.0.0
 */
public class Arrays {

    public static <T> List<T> asList(T... a) {
        if (a == null)
            throw new NullPointerException();

        List<T> list = new ArrayList<>();
        for(T t : a) {
            list.add(t);
        }
        return list;
    }

}
