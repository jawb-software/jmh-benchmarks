package de.jawb.jmh.benchmark.util;

import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.gson.Gson;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;

import de.jawb.jmh.benchmark.json.model.Person;
import de.jawb.jmh.benchmark.util.ResourceLoader;
import io.github.benas.randombeans.api.EnhancedRandom;

public class PersonGenerator {

    public static void generate() throws Exception {
        List<Person> persons = EnhancedRandom.randomListOf(100_000, Person.class);
        ObjectMapper m = new ObjectMapper();
        // m.enable(SerializationFeature.INDENT_OUTPUT);

        try (PrintWriter out = new PrintWriter("filename.txt")) {
            out.println(m.writeValueAsString(persons));
        }
    }

    public static void main(String[] args) throws Exception {

//        Person person = EnhancedRandom.random(Person.class);
//        String json = new Gson().toJson(person);
//        JsonPrimitive obj = (JsonPrimitive) new Gson().toJsonTree(json);
//
//        System.out.println(obj.isString());

        generate();
    }
}
