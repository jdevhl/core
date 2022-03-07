package com.github.jdevhl.parser;

import com.github.jdevhl.parser.dto.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JSONParserTest {

    @Test
    public void toObjectTest() {
        String personStr = "{\n" +
                "  \"name\": \"Oscar\",\n" +
                "  \"surname\": \"Montes\"\n" +
                "}";
        JSONParser jaxbParser = new JSONParser();
        Person person = (Person) jaxbParser.toObject(personStr, Person.class);
        assertNotNull(person);
        assertEquals("Oscar", person.getName());
        assertEquals("Montes", person.getSurname());

    }

}