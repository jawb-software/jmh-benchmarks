package de.jawb.jmh.benchmark.json;

import de.jawb.jmh.benchmark.json.mapper.GsonMapper;
import de.jawb.jmh.benchmark.json.mapper.JacksonMapper;
import de.jawb.jmh.benchmark.json.model.Address;
import de.jawb.jmh.benchmark.json.model.Person;
import de.jawb.jmh.benchmark.util.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MapperTest {

    private final static Person referencePerson = Person.of("A", "B", 42, Address.of("Mainstr.", "1", "12345", "City"));

    private final static String manyPersons = ResourceLoader.getContent("persons.json");
    private final static String onePerson   = ResourceLoader.getContent("oneperson.json");

    @Test
    public void testMapper_FromJson_one() {
        Person p1 = JacksonMapper.oneFromJson(onePerson);
        Person p2 = GsonMapper.oneFromJson(onePerson);

        Assert.assertEquals(p1, p2);
        Assert.assertEquals(p1, referencePerson);
    }

    @Test
    public void testMapper_FromJson_list() {
        List<Person> list1 = JacksonMapper.listFromJson(manyPersons);
        List<Person> list2 = GsonMapper.listFromJson(manyPersons);

        Assert.assertEquals(list1.size(), list2.size());
        Assert.assertEquals(list1, list2);
    }


    @Test
    public void testMapper_ToJson_one() {
        String s1 = JacksonMapper.toJson(referencePerson);
        String s2 = GsonMapper.toJson(referencePerson);

        Assert.assertEquals(s1, s2);
        Assert.assertEquals(s1, onePerson);
    }

    @Test
    public void testMapper_ToJson_list() {

        List<Person> list1 = JacksonMapper.listFromJson(manyPersons);

        String s1 = JacksonMapper.toJson(list1);
        String s2 = GsonMapper.toJson(list1);

        Assert.assertEquals(s1, s2);
        Assert.assertEquals(s1, manyPersons);
    }


}
