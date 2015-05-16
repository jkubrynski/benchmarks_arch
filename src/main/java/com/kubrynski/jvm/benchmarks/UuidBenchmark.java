package com.kubrynski.jvm.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Jakub Kubrynski
 */
@Warmup(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 5, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 2)
public class UuidBenchmark {

	@Benchmark
	public String generateUuid() {
		return UUID.randomUUID().toString();
	}

}

//64bit 1.8.0_45-b14
//UuidBenchmark.buildUuid  avgt   10  2924.757 ± 79.087  ns/op

//64bit 1.8.0_45-b14 -Xint
//UuidBenchmark.buildUuid  avgt   10  35516.674 ± 332.106  ns/op

//32bit 1.8.0_45-b14
//Benchmark                Mode  Cnt     Score    Error  Units
//UuidBenchmark.buildUuid  avgt   10  3120.139 ± 33.138  ns/op

//32bit 1.8.0_45-b14 -Xint
//UuidBenchmark.buildUuid  avgt   10  27011.153 ± 587.028  ns/op
