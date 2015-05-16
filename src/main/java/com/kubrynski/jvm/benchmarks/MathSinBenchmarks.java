package com.kubrynski.jvm.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.CompilerControl;
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
public class MathSinBenchmarks {


	public final static double[] doubles = new double[10_000];

	static {
		for (int i = 0; i < 10_000; i++) {
			doubles[i] = i/100;
		}
	}

	@Benchmark
	@CompilerControl(CompilerControl.Mode.PRINT)
	public double sin() {
		double result = 0;

		for (double aDouble : doubles) {
			if (aDouble > 0) {
				result = aDouble;
			}
		}
		return result;
	}

}