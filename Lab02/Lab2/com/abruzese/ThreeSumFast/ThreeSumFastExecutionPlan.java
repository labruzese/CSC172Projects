package com.abruzese.ThreeSumFast;

import com.abruzese.In;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;


@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 15, time = 5, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ThreeSumFastExecutionPlan {
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
            case "benchThreeSumFast1K" -> benchThreeSumFast1K();
            case "benchThreeSumFast2K" -> benchThreeSumFast2K();
            case "benchThreeSumFast4K" -> benchThreeSumFast4K();
            case "benchThreeSumFast8K" -> benchThreeSumFast8K();
            case "benchThreeSumFast16K" -> benchThreeSumFast16K();
            default -> 0;
        };
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchThreeSumFast1K() {
        return ThreeSumFast.count(oneK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchThreeSumFast2K() {
        return ThreeSumFast.count(twoK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchThreeSumFast4K() {
        return ThreeSumFast.count(fourK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchThreeSumFast8K() {
        return ThreeSumFast.count(eightK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchThreeSumFast16K() {
        return ThreeSumFast.count(sixteenK);
    }
}
