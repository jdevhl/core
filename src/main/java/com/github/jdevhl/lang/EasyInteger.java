package com.github.jdevhl.lang;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
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
            log.error("Error in EasyInteger.getSafecyValue {} ", e.getMessage());
        }
        return intValue;
    }
}
