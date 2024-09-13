package com.abruzese.ThreeSumExtraFast;

import com.abruzese.In;
import com.abruzese.ThreeSumExtraFast.ThreeSumExtraFast;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Estimated Runtime:
 */
@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 15, time = 5, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ThreeSumExtraFastExecutionPlan32K {
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
            case "benchThreeSumExtraFast32K" -> benchThreeSumExtraFast32K();
            //case "benchThreeSumExtraFast1M" -> benchThreeSumExtraFast1M();
            default -> 0;
        };
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchThreeSumExtraFast32K() {
        return ThreeSumExtraFast.count(thirtyTwoK);
    }

//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    public int benchThreeSumExtraFast1M() {
//        return ThreeSumExtraFast.count(oneM);
//    }
}
