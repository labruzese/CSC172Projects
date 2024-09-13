package com.abruzese.TwoSumFast;

import com.abruzese.In;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Expected Execution Time: a few minutes
 */
@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 15, time = 5, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class TwoSumFastExecutionPlan {
    int[] oneK;
    int[] twoK;
    int[] fourK;
    int[] eightK;
    int[] sixteenK;
    int[] thirtyTwoK;
    int[] oneM;

    @Setup(Level.Trial)
    public void setup() {
        oneK = new In("1Kints.txt").readAllInts();
        twoK = new In("2Kints.txt").readAllInts();
        fourK = new In("4Kints.txt").readAllInts();
        eightK = new In("8Kints.txt").readAllInts();
        sixteenK = new In("16Kints.txt").readAllInts();
//        thirtyTwoK = new In("32Kints.txt").readAllInts();
//        oneM = new In("1Mints.txt").readAllInts();
    }

    public int getResult(String benchmarkName){
        return switch (benchmarkName) {
            case "benchTwoSumFast1K" -> benchTwoSumFast1K();
            case "benchTwoSumFast2K" -> benchTwoSumFast2K();
            case "benchTwoSumFast4K" -> benchTwoSumFast4K();
            case "benchTwoSumFast8K" -> benchTwoSumFast8K();
            case "benchTwoSumFast16K" -> benchTwoSumFast16K();
            default -> 0;
        };
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchTwoSumFast1K() {
        return TwoSumFast.count(oneK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchTwoSumFast2K() {
        return TwoSumFast.count(twoK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchTwoSumFast4K() {
        return TwoSumFast.count(fourK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchTwoSumFast8K() {
        return TwoSumFast.count(eightK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchTwoSumFast16K() {
        return TwoSumFast.count(sixteenK);
    }
}
