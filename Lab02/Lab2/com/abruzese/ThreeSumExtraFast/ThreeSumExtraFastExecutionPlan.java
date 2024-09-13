package com.abruzese.ThreeSumExtraFast;

import com.abruzese.In;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;


@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 15, time = 5, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ThreeSumExtraFastExecutionPlan {
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
            case "benchThreeSumExtraFast1K" -> benchThreeSumExtraFast1K();
            case "benchThreeSumExtraFast2K" -> benchThreeSumExtraFast2K();
            case "benchThreeSumExtraFast4K" -> benchThreeSumExtraFast4K();
            case "benchThreeSumExtraFast8K" -> benchThreeSumExtraFast8K();
            case "benchThreeSumExtraFast16K" -> benchThreeSumExtraFast16K();
            default -> 0;
        };
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchThreeSumExtraFast1K() {
        return ThreeSumExtraFast.count(oneK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchThreeSumExtraFast2K() {
        return ThreeSumExtraFast.count(twoK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchThreeSumExtraFast4K() {
        return ThreeSumExtraFast.count(fourK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchThreeSumExtraFast8K() {
        return ThreeSumExtraFast.count(eightK);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public int benchThreeSumExtraFast16K() {
        return ThreeSumExtraFast.count(sixteenK);
    }
}
