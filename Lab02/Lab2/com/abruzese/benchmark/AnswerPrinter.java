package com.abruzese.benchmark;

import com.abruzese.ThreeSum.ThreeSumExecutionPlan;
import org.openjdk.jmh.results.RunResult;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

public class AnswerPrinter {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOLD = "\u001B[1m";

    public static void printResults(Collection<RunResult> results) {
        ThreeSumExecutionPlan ep = new ThreeSumExecutionPlan();
        ep.setup();

        System.out.println("\n\n");

        System.out.printf(ANSI_BOLD + "%6s    %10s    %15s  %7s  %16s  %8s  %13s" + ANSI_RESET +"\n",
                "Result", "Iterations", "AvgTime ± Error", "StDev", "Timestamp", "NetID", "File");

        List<RunResult> resultList = new ArrayList<>(results);

        resultList.sort((r1, r2) -> {
            Double result1 = r1.getPrimaryResult().getScore();
            Double result2 = r2.getPrimaryResult().getScore();
            return result1.compareTo(result2);
        });

        for (RunResult result : resultList) {
            String benchmarkInternalName = result.getPrimaryResult().getLabel();

            Integer benchmarkResult = ep.getResult(benchmarkInternalName);

            long iterations = result.getPrimaryResult().getStatistics().getN();

            String avgTimeWithError = String.format("%.3f ± %.3f",
                    result.getPrimaryResult().getScore(),
                    result.getPrimaryResult().getScoreError()
            );

            double stdev = result.getPrimaryResult().getStatistics().getStandardDeviation();

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());


            String netId = "labruzes";

            String fileName = Pattern.compile(".*?(\\d+.*)").matcher(benchmarkInternalName).replaceAll("$1ints.txt");

            System.out.printf("%6d    %10d    %15s  %7.3f  %16s  %8s  %13s\n",
                    benchmarkResult,
                    iterations,
                    avgTimeWithError,
                    stdev,
                    timeStamp,
                    netId,
                    fileName
            );
        }
    }
}