package de.jawb.jmh.benchmark.json.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import de.jawb.jmh.benchmark.json.model.Person;

import java.util.ArrayList;
import java.util.List;

public class JacksonMapper {

    private final static ObjectMapper   MAPPER              = new ObjectMapper();
    private final static CollectionType JACKSON_LIST_TYPE   = MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Person.class);

    public static List<Person> listFromJson(String jsonString) {
        try {
            return MAPPER.readValue(jsonString, JACKSON_LIST_TYPE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Person oneFromJson(String jsonString) {
        try {
            return MAPPER.readValue(jsonString, Person.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String toJson(Object o){
        try {
            return MAPPER.writeValueAsString(o);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
