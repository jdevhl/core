package com.github.jdevhl.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JAXBParserTest {

    @Test
    public void toObjectTest() {
        String xml = "<person><name>Oscar</name><surname>Montes</surname></person>";

        JAXBParser jaxbParser = new JAXBParser(PersonXml.class);
        PersonXml person = (PersonXml) jaxbParser.toObject(xml);
        assertNotNull(person);
        assertEquals("Oscar", person.getName());
        assertEquals("Montes", person.getSurname());
    }

}