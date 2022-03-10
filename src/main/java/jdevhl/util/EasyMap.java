package jdevhl.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Utility class for use of Maps.
 *
 * @author Oscar Montes
 * @see java.util.Map
 * @since 1.0.0
 */
public class EasyMap {

    public static boolean isEmpty(Map<?, ?> value) {
        if (value == null) {
            return true;
        }
        return value.size() == 0;
    }

    public static boolean isNotEmpty(Map<?, ?> value) {
        return !isEmpty(value);
    }

    public static Map<?, ?> sort(Map<?, ?> map) {
        if (isEmpty(map)) {
            return map;
        }
        checkMapComparableValues(map);
        final Map<Comparable, Comparable> mabObj = (Map<Comparable, Comparable>) map;
        return mabObj.entrySet().stream().sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    }

    private static void checkMapComparableValues(Map<?, ?> map) {
        final Object key = map.keySet().stream().findFirst().get();
        if (!isComparable(key)) {
            throw new IllegalArgumentException("Key must be Comparable");
        }
        if (!isComparable(map.get(key))) {
            throw new IllegalArgumentException("Value must be Comparable");
        }
    }

    private static boolean isComparable(Object key) {
        return key instanceof Comparable;
    }
}
