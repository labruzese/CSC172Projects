package com.abruzese.benchmark;

import com.abruzese.Stopwatch;
import com.abruzese.ThreeSum.ThreeSumExecutionPlan;
import com.abruzese.TwoSum.TwoSumExecutionPlan;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.Collection;

public class BenchmarkRunner {

    private static final String EXECUTION_PLAN = TwoSumExecutionPlan.class.getSimpleName();

    public static void main(String[] args) throws IOException, RunnerException {
        long millisStart = System.currentTimeMillis();

        Options opt = new OptionsBuilder()
                .include(EXECUTION_PLAN)
                .forks(3)
                .build();

        Collection<RunResult> results = new Runner(opt).run();

        System.out.printf("Total Benchmark Duration: %1f minutes", (((System.currentTimeMillis() - millisStart)*1.0)/1000) / 60);

        AnswerPrinter.printResults(results);
    }
}