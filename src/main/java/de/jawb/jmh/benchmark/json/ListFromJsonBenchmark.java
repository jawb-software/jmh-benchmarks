package de.jawb.jmh.benchmark.json;

import java.util.List;
import java.util.concurrent.TimeUnit;

import de.jawb.jmh.benchmark.json.mapper.GsonMapper;
import de.jawb.jmh.benchmark.json.mapper.JacksonMapper;
import de.jawb.jmh.benchmark.json.model.Person;
import de.jawb.jmh.benchmark.util.ResourceLoader;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 3, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
public class ListFromJsonBenchmark {

    private String personsAsJson = ResourceLoader.getContent("persons_1000.json"); // 200 KB

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
