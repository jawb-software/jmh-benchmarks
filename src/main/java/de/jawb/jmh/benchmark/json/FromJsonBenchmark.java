package de.jawb.jmh.benchmark.json;

import de.jawb.jmh.benchmark.json.mapper.GsonMapper;
import de.jawb.jmh.benchmark.json.mapper.JacksonMapper;
import de.jawb.jmh.benchmark.json.model.Person;
import de.jawb.jmh.benchmark.util.ResourceLoader;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
public class FromJsonBenchmark {

    @Param({"1", "100", "1000", "10000"})
    private String persons;

    private String personsAsJson;

    @Setup
    public void setup() {
        personsAsJson = ResourceLoader.getContent("persons_" + persons + ".json");
    }

    @Benchmark
    public void fromJson_gson(Blackhole bh) {
        List<Person> personList = GsonMapper.listFromJson(personsAsJson);
        bh.consume(personList);
    }

    @Benchmark
    public void fromJson_jackson(Blackhole bh) {
        List<Person> personList = JacksonMapper.listFromJson(personsAsJson);
        bh.consume(personList);
    }
}
