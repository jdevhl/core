package jdevhl.util;

import jdevhl.common.dto.Person;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EasyMapTest {

    @Test
    public void sortMapIntegerTest() {
        Map<String, Integer> mapUnsorted = new HashMap<>();
        mapUnsorted.put("casa", 1);
        mapUnsorted.put("avion", 3);
        mapUnsorted.put("Zapatero", 2);
        mapUnsorted.put("armario", 4);
        Map<String, Integer> mapSorted = (Map<String, Integer>) EasyMap.sort(mapUnsorted);
        int cont = 1;
        for (String key : mapSorted.keySet()) {
            assertEquals(cont, mapSorted.get(key));
            cont += 1;
        }
    }

    @Test
    public void sortMapStringTest() {
        Map<String, String> mapUnsorted = new HashMap<>();
        mapUnsorted.put("casa", "blanca");
        mapUnsorted.put("avion", "azul");
        mapUnsorted.put("Zapatero", "pequeño");
        mapUnsorted.put("armario", "grande");
        Map<String, String> mapSorted = (Map<String, String>) EasyMap.sort(mapUnsorted);
        String[] values = {"azul", "blanca", "grande", "pequeño"};
        int cont = 0;
        for (String key : mapSorted.keySet()) {
            assertEquals(values[cont], mapSorted.get(key));
            cont += 1;
        }
    }

    @Test
    public void sortMapLongTest() {
        Map<String, Long> mapUnsorted = new HashMap<>();
        mapUnsorted.put("casa", 3L);
        mapUnsorted.put("avion", 2L);
        mapUnsorted.put("Zapatero", 1L);
        mapUnsorted.put("armario", 4L);
        Map<String, String> mapSorted = (Map<String, String>) EasyMap.sort(mapUnsorted);
        Long cont = 1L;
        for (String key : mapSorted.keySet()) {
            assertEquals(cont, mapSorted.get(key));
            cont += 1L;
        }
    }

    @Test
    public void sortMapBigDecimalTest() {
        Map<String, BigDecimal> mapUnsorted = new HashMap<>();
        mapUnsorted.put("casa", BigDecimal.valueOf(3L));
        mapUnsorted.put("avion", BigDecimal.valueOf(2L));
        mapUnsorted.put("Zapatero", BigDecimal.valueOf(1L));
        mapUnsorted.put("armario", BigDecimal.valueOf(4L));
        Map<String, String> mapSorted = (Map<String, String>) EasyMap.sort(mapUnsorted);
        BigDecimal cont = BigDecimal.ONE;
        for (String key : mapSorted.keySet()) {
            assertEquals(cont, mapSorted.get(key));
            cont = cont.add(BigDecimal.ONE);
        }
    }

    @Test
    public void sortMapIllegalArgumentExceptionTest() {
        Map<Person, Integer> mapUnsorted = new HashMap<>();
        mapUnsorted.put(new Person(), 1);

        assertThrows(IllegalArgumentException.class, () -> {
            EasyMap.sort(mapUnsorted);
        });

        Map<Integer, Person> mapUnsorted2 = new HashMap<>();
        mapUnsorted2.put(1, new Person());

        assertThrows(IllegalArgumentException.class, () -> {
            EasyMap.sort(mapUnsorted);
        });
    }


}