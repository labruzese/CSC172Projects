package com.abruzese.TwoSumFast;

import com.abruzese.In;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Expected Execution Time: unknown
 */
@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 15, time = 5, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class TwoSumFastExecutionPlan1M {
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
        oneM = new In("1Mints.txt").readAllInts();
    }

    public int getResult(String benchmarkName){
        return switch (benchmarkName) {
            case "benchTwoSumFast32K" -> benchTwoSumFast32K();
            case "benchTwoSumFast1M" -> benchTwoSumFast1M();
            default -> 0;
        };
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchTwoSumFast32K() {
        return TwoSumFast.count(thirtyTwoK);
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchTwoSumFast1M() {
        return TwoSumFast.count(oneM);
    }
}
