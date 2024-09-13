package com.abruzese.TwoSum;

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
public class TwoSumExecutionPlan {
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
            case "benchTwoSum1K" -> benchTwoSum1K();
            case "benchTwoSum2K" -> benchTwoSum2K();
            case "benchTwoSum4K" -> benchTwoSum4K();
            case "benchTwoSum8K" -> benchTwoSum8K();
            case "benchTwoSum16K" -> benchTwoSum16K();
            default -> 0;
        };
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchTwoSum1K() {
        return TwoSum.count(oneK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchTwoSum2K() {
        return TwoSum.count(twoK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchTwoSum4K() {
        return TwoSum.count(fourK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchTwoSum8K() {
        return TwoSum.count(eightK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchTwoSum16K() {
        return TwoSum.count(sixteenK);
    }
}
