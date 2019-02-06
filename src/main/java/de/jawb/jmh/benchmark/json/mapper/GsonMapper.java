package de.jawb.jmh.benchmark.json.mapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import de.jawb.jmh.benchmark.json.model.Person;

import java.lang.reflect.Type;
import java.util.List;

public class GsonMapper {

    private final static Gson gson           = new Gson();
    private final static Type GSON_LIST_TYPE = new TypeToken<List<Person>>() {}.getType();

    public static List<Person> listFromJson(String jsonString) {
        return gson.fromJson(jsonString, GSON_LIST_TYPE);
    }

    public static Person oneFromJson(String jsonString) {
        return gson.fromJson(jsonString, Person.class);
    }

    public static String toJson(Object o){
        return gson.toJson(o);
    }

}
