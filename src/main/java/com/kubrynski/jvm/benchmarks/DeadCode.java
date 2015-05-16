package com.kubrynski.jvm.benchmarks;

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
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 0)
//, jvmArgsAppend = {"-XX:+UnlockDiagnosticVMOptions", "-XX:+TraceClassLoading", "-XX:+LogCompilation", "-XX:LogFile=deadcode.log", "-XX:+PrintAssembly"})
public class DeadCode {

//	@Benchmark
	public long withReturnValueInLoopOperation_1000() {
		long a = 0;
		for (int i = 0; i < 1_000; i++) {
			if (i % 2 == 0) {
				a = i;
			}
		}
		return a;
	}


//	@Benchmark
	public long withReturnValueInLoopOperation_10000() {
		long a = 0;
		for (int i = 0; i < 10_000; i++) {
			if (i % 2 == 0) {
				a = i;
			}
		}
		return a;
	}

//	@Benchmark
	public long withReturnValue_1000() {
		long a = 0;
		for (int i = 0; i < 1_000; i++) {
			a = i;
		}
		return a;
	}


//	@Benchmark
	public long withReturnValue_10000() {
		long a = 0;
		for (int i = 0; i < 10_000; i++) {
			a = i;
		}
		return a;
	}

//	@Benchmark
	public void withoutReturnValueInLoopOperation_1000() {
		long a = 0;
		for (int i = 0; i < 1_000; i++) {
			if (i % 2 == 0) {
				a = i;
			}
		}
	}


//	@Benchmark
	public void withoutReturnValueInLoopOperation_10000() {
		long a = 0;
		for (int i = 0; i < 10_000; i++) {
			if (i % 2 == 0) {
				a = i;
			}
		}
	}


//	@Benchmark
	public void withoutReturnValue_1000() {
		long a = 0;
		for (int i = 0; i < 1_000; i++) {
			a = i;
		}
	}


//	@Benchmark
	public void withoutReturnValue_10000() {
		long a = 0;
		for (int i = 0; i < 10_000; i++) {
			a = i;
		}
	}
}

//		Benchmark                                         Mode  Cnt     Score     Error  Units
//		DeadCode.withReturnValueInLoopOperation_1000      avgt   10   771.415 ±   9.578  ns/op
//		DeadCode.withReturnValueInLoopOperation_10000     avgt   10  7694.773 ± 101.412  ns/op
//		DeadCode.withReturnValue_1000                     avgt   10     2.330 ±   0.044  ns/op
//		DeadCode.withReturnValue_10000                    avgt   10     2.304 ±   0.014  ns/op
//		DeadCode.withoutReturnValueInLoopOperation_1000   avgt   10     0.330 ±   0.021  ns/op
//		DeadCode.withoutReturnValueInLoopOperation_10000  avgt   10     0.321 ±   0.004  ns/op
//		DeadCode.withoutReturnValue_1000                  avgt   10     0.326 ±   0.010  ns/op
//		DeadCode.withoutReturnValue_10000                 avgt   10     0.387 ±   0.021  ns/op