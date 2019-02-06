package de.jawb.jmh.benchmark.json;

import de.jawb.jmh.benchmark.json.mapper.GsonMapper;
import de.jawb.jmh.benchmark.json.mapper.JacksonMapper;
import de.jawb.jmh.benchmark.json.model.Address;
import de.jawb.jmh.benchmark.json.model.Person;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 3, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
public class OneToJsonBenchmark {

    private Person person = Person.of("A", "B", 42, Address.of("Mainstr.", "1", "12345", "City"));

    @Benchmark
    public void toJson_gson(Blackhole bh) {
        String json = GsonMapper.toJson(person);
        bh.consume(json);
    }

    @Benchmark
    public void toJson_jackson(Blackhole bh) {
        String json = JacksonMapper.toJson(person);
        bh.consume(json);
    }

}
