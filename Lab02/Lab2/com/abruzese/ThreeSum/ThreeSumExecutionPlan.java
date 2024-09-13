package com.abruzese.ThreeSum;

import com.abruzese.In;
import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

/**
 * Estimated Runtime: about 4 hours
 */
@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 15, time = 5, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ThreeSumExecutionPlan {
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
        thirtyTwoK = new In("32Kints.txt").readAllInts();
        oneM = new In("1Mints.txt").readAllInts();
    }

    public int getResult(String benchmarkName){
        return switch (benchmarkName) {
            case "benchThreeSum1K" -> benchThreeSum1K();
            case "benchThreeSum2K" -> benchThreeSum2K();
            case "benchThreeSum4K" -> benchThreeSum4K();
            case "benchThreeSum8K" -> benchThreeSum8K();
            case "benchThreeSum16K" -> benchThreeSum16K();
            default -> 0;
        };
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchThreeSum1K() {
        return ThreeSum.count(oneK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchThreeSum2K() {
        return ThreeSum.count(twoK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchThreeSum4K() {
        return ThreeSum.count(fourK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchThreeSum8K() {
        return ThreeSum.count(eightK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchThreeSum16K() {
        return ThreeSum.count(sixteenK);
    }
}
