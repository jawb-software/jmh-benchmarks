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
@Measurement(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
public class ToJsonBenchmark {

    @Param({"10", "100", "1000", "10000", "100000"})
    private String       persons;

    private List<Person> personList;

    @Setup
    public void setup() {
        String json = ResourceLoader.getContent("persons_" + persons + ".json");
        personList  = JacksonMapper.listFromJson(json);
    }

    @Benchmark
    public void toJson_gson(Blackhole bh) {
        String json = GsonMapper.toJson(personList);
        bh.consume(json);
    }

    @Benchmark
    public void toJson_jackson(Blackhole bh) {
        String json = JacksonMapper.toJson(personList);
        bh.consume(json);
    }

}
