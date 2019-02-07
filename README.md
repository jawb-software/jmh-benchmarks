# template-jmh-benchmark

Gson vs Jackson

Resuls (Windows):
```
Benchmark                                   Mode  Cnt        Score        Error  Units
BigListFromJsonBenchmark.fromJson_gson     thrpt    5       70,881 ±      4,360  ops/s
BigListFromJsonBenchmark.fromJson_jackson  thrpt    5       75,714 ±      3,423  ops/s
BigListToJsonBenchmark.toJson_gson         thrpt    5       46,271 ±     15,459  ops/s
BigListToJsonBenchmark.toJson_jackson      thrpt    5       82,662 ±      5,968  ops/s
ListFromJsonBenchmark.fromJson_gson        thrpt    5      719,846 ±     42,348  ops/s
ListFromJsonBenchmark.fromJson_jackson     thrpt    5      800,630 ±     42,646  ops/s
ListToJsonBenchmark.toJson_gson            thrpt    5      493,565 ±    187,396  ops/s
ListToJsonBenchmark.toJson_jackson         thrpt    5     1064,431 ±     53,000  ops/s
OneFromJsonBenchmark.fromJson_gson         thrpt    5   707307,089 ±  26826,032  ops/s
OneFromJsonBenchmark.fromJson_jackson      thrpt    5   930969,191 ±  62236,452  ops/s
OneToJsonBenchmark.toJson_gson             thrpt    5   577306,469 ± 236190,042  ops/s
OneToJsonBenchmark.toJson_jackson          thrpt    5  1529821,844 ±  91545,276  ops/s
```