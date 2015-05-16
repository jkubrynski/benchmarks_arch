To run those benchmarks just type

```
mvn clean package
java -jar target/archbenchmark.jar
```


2 cores Intel(R) Core(TM) i7-4600U CPU @ 2.10GHz Linux 3.19.7-200 1.8.0_45-b14 64bit 
Benchmark                         Mode  Cnt     Score    Error  Units
MathMaxBenchmarks,maxInt          avgt   20  2790,969 ±  9,975  ns/op
MathMaxBenchmarks,maxLong         avgt   20  3227,029 ± 11,873  ns/op
TimeBenchmarks,currentTimeMillis  avgt   20    22,449 ±  0,162  ns/op
TimeBenchmarks,nanoTime           avgt   20    20,161 ±  0,069  ns/op
UuidBenchmark,generateUuid        avgt   20  2867,699 ± 19,161  ns/op

2 cores Intel(R) Core(TM) i7-4600U CPU @ 2.10GHz Linux 3.19.7-200 1.8.0_45-b14 32bit 
Benchmark                         Mode  Cnt     Score    Error  Units
MathMaxBenchmarks,maxInt          avgt   20  2780,503 ± 20,034  ns/op
MathMaxBenchmarks,maxLong         avgt   20  8289,475 ± 28,730  ns/op
TimeBenchmarks,currentTimeMillis  avgt   20   113,662 ±  0,306  ns/op
TimeBenchmarks,nanoTime           avgt   20   128,986 ±  0,832  ns/op
UuidBenchmark,generateUuid        avgt   20  3084,681 ± 32,180  ns/op