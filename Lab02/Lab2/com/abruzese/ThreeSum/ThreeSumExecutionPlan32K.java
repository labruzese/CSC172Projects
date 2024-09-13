package com.abruzese.ThreeSum;

import com.abruzese.In;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Estimated Runtime: about 1 hour per iteration
 */
@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 15, time = 5, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ThreeSumExecutionPlan32K {
    int[] oneK;
    int[] twoK;
    int[] fourK;
    int[] eightK;
    int[] sixteenK;
    int[] thirtyTwoK;
    int[] oneM;

    @Setup(Level.Trial)
    public void setup() {
//        oneK = new In("1Kints.txt").readAllInts();
//        twoK = new In("2Kints.txt").readAllInts();
//        fourK = new In("4Kints.txt").readAllInts();
//        eightK = new In("8Kints.txt").readAllInts();
//        sixteenK = new In("16Kints.txt").readAllInts();
        thirtyTwoK = new In("32Kints.txt").readAllInts();
//        oneM = new In("1Mints.txt").readAllInts();
    }

    public int getResult(String benchmarkName){
        return switch (benchmarkName) {
            case "benchThreeSum32K" -> benchThreeSum32K();
            //case "benchThreeSum1M" -> benchThreeSum1M();
            default -> 0;
        };
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchThreeSum32K() {
        return ThreeSum.count(thirtyTwoK);
    }

//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    public int benchThreeSum1M() {
//        return ThreeSum.count(oneM);
//    }
}
