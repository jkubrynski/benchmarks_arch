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
@Warmup(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 5, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 2)
public class MathMaxBenchmarks {


	public final static long[] longs = new long[10_000];
	public final static int[] ints = new int[10_000];

	static {
		for (int i = 0; i < 10_000; i++) {
			longs[i] = i;
			ints[i] = i;
		}
	}

	@Benchmark
	public long maxLong() {
		long max = Long.MIN_VALUE;
		for (long aLong : longs) {
			if (aLong > max) {
				max = aLong;
			}
		}
		return max;
	}

	@Benchmark
	public long maxInt() {
		int max = Integer.MIN_VALUE;
		for (int anInt : ints) {
			if (anInt > max) {
				max = anInt;
			}
		}
		return max;
	}

}

//64bit 1.8.0_45-b14
//Benchmark                  Mode  Cnt     Score    Error  Units
//MathMaxBenchmarks.maxInt   avgt   10  2831.370 ± 21.929  ns/op
//MathMaxBenchmarks.maxLong  avgt   10  3261.187 ± 30.205  ns/op

//64bit 1.8.0_45-b14 -Xint
//Benchmark                  Mode  Cnt       Score      Error  Units
//MathMaxBenchmarks.maxInt   avgt   10  154393.527 ± 6184.749  ns/op
//MathMaxBenchmarks.maxLong  avgt   10  166361.524 ± 2058.170  ns/op

//32bit 1.8.0_45-b14
//Benchmark                  Mode  Cnt     Score     Error  Units
//MathMaxBenchmarks.maxInt   avgt   10  2857.247 ±  80.885  ns/op
//MathMaxBenchmarks.maxLong  avgt   10  8569.549 ± 196.315  ns/op

//32bit 1.8.0_45-b14 -Xint
//Benchmark                  Mode  Cnt       Score       Error  Units
//MathMaxBenchmarks.maxInt   avgt   10  128125.840 ±  7639.000  ns/op
//MathMaxBenchmarks.maxLong  avgt   10  158356.130 ± 10769.219  ns/op

