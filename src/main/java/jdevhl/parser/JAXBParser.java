package jdevhl.parser;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import lombok.extern.slf4j.Slf4j;

import java.io.StringReader;

/**
 * Utility class for use of JAXB.
 *
 * @author Oscar Montes
 * @see jakarta.xml.bind.JAXBContext
 * @since 1.0.0
 */
@Slf4j
public class JAXBParser {

    private JAXBContext jaxbContext;

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
