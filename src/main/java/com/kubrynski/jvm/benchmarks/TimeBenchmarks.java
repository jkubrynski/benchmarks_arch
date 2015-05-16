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

import java.util.concurrent.TimeUnit;

/**
 * @author Jakub Kubrynski
 */
@Warmup(iterations = 5, time = 10, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 10, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1)
public class TimeBenchmarks {

	@Benchmark
	public long nanoTime() {
		return System.nanoTime();
	}

	@Benchmark
	public long currentTimeMillis() {
		return System.currentTimeMillis();
	}
}

//64bit 1.8.0_45-b14
//Benchmark                 Mode  Cnt   Score   Error  Units
//System.currentTimeMillis  avgt   10  22.684 ± 0.220  ns/op
//System.nanoTime           avgt   10  20.607 ± 0.763  ns/op

//64bit 1.8.0_45-b14 -Xint
//Benchmark                         Mode  Cnt    Score   Error  Units
//TimeBenchmarks.currentTimeMillis  avgt   10  191.336 ± 3.037  ns/op
//TimeBenchmarks.nanoTime           avgt   10  195.456 ± 5.429  ns/op

//32bit 1.8.0_45-b14
//Benchmark                 Mode  Cnt    Score   Error  Units
//System.currentTimeMillis  avgt   10  116.492 ± 2.904  ns/op
//System.nanoTime           avgt   10  130.266 ± 1.522  ns/op

//32bit 1.8.0_45-b14 -Xint
//Benchmark                         Mode  Cnt    Score   Error  Units
//TimeBenchmarks.currentTimeMillis  avgt   10  208.145 ± 2.353  ns/op
//TimeBenchmarks.nanoTime           avgt   10  222.055 ± 8.311  ns/op
