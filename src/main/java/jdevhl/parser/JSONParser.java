package jdevhl.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
            log.error("Error to convert to JSON Object", e);
        }
        return object;
    }
}
