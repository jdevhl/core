package jdevhl.parser;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

import java.io.StringReader;

/**
 * Utility class for use of JAXB.
 *
 * @author Oscar Montes
 * @see jakarta.xml.bind.JAXBContext
 * @since 1.0.0
 */
public class JAXBParser {

    private JAXBContext jaxbContext;

    public JAXBParser(Class clazz) {
        try {
            this.jaxbContext = JAXBContext.newInstance(clazz);
        } catch (JAXBException e) {

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

        }
        return result;
    }

}
