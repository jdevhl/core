package com.github.jdevhl.parser;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import lombok.extern.slf4j.Slf4j;

import java.io.StringReader;

@Slf4j
public class JAXBParser {

    private static final String HOUSE_HOLD_TAG = "<fullHouseholdDTO>";
    private static final String LEGAL_ENTITY_TAG = "<fullLegalEntityDTO>";

    private JAXBContext jaxbContext;

    // Unmarshaller is not Thread Safe
    // private Unmarshaller unmarshaller;

    public JAXBParser(Class clazz) {
        try {
            this.jaxbContext = JAXBContext.newInstance(clazz);
        } catch (JAXBException e) {
            log.error("Error creating JaxbContext {}", e.getMessage());
        }
    }

    /**
     * @param value
     * @return
     */
    public Object toObject(String value) {
        Object result = null;
        try {
            result = jaxbContext.createUnmarshaller().unmarshal(new StringReader(value));
        } catch (JAXBException e) {
            log.error("unmarshal error with JAXBElement {}", e.getMessage());
        }
        return result;
    }
}
