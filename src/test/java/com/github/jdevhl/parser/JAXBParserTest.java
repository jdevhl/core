package com.github.jdevhl.parser;

import com.github.jdevhl.parser.dto.PersonXml;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JAXBParserTest {

    @Test
    public void toObjectTest() {
        String xml = "<?xml version=\"1.0\"?><person><name>Oscar</name><surname>Montes</surname></person>";

        JAXBParser jaxbParser = new JAXBParser(PersonXml.class);
        PersonXml person = (PersonXml) jaxbParser.toObject(xml);
        assertNotNull(person);
        assertEquals("Oscar", person.getName());
        assertEquals("Montes", person.getSurname());
    }

}