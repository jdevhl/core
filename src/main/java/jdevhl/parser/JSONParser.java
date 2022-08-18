package jdevhl.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class for use of Json.
 *
 * @author Oscar Montes
 * @since 1.0.0
 */
public class JSONParser {

    private ObjectMapper objectMapper;

    public JSONParser() {
        objectMapper = new ObjectMapper();
    }

    /**
     * @param value
     * @param clazz
     * @return
     */
    public Object toObject(String value, Class clazz) {
        Object object = null;
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        try {
            object = objectMapper.readValue(value, clazz);
        } catch (JsonProcessingException e) {

        }
        return object;
    }
}
