package com.abruzese.TwoSum; /******************************************************************************
 *  Compilation:  javac com.abruzese.TwoSum.TwoSum.java
 *  Execution:    java com.abruzese.TwoSum.TwoSum input.txt
 *  Dependencies: com.abruzese.StdOut.java com.abruzese.In.java com.abruzese.Stopwatch.java
 *  Data files:   http://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program with n^2 running time. Reads n integers
 *  and counts the number of pairs that sum to exactly 0.
 *
 *
 *  Limitations
 *  -----------
 *     - we ignore integer overflow
 *
 *
 *  % java com.abruzese.TwoSum.TwoSum 2Kints.txt
 *  2
 *
 *  % java com.abruzese.TwoSum.TwoSum 1Kints.txt
 *  1
 *
 *  % java com.abruzese.TwoSum.TwoSum 2Kints.txt
 *  2
 *
 *  % java com.abruzese.TwoSum.TwoSum 4Kints.txt
 *  3
 *
 *  % java com.abruzese.TwoSum.TwoSum 8Kints.txt
 *  19
 *
 *  % java com.abruzese.TwoSum.TwoSum 16Kints.txt
 *  66
 *
 *  % java com.abruzese.TwoSum.TwoSum 32Kints.txt
 *  273
 *
 ******************************************************************************/

import com.abruzese.In;
import com.abruzese.StdOut;
import com.abruzese.Stopwatch;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TwoSum {

    // print distinct pairs (i, j) such that a[i] + a[j]  = 0
    public static void printAll(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (a[i] + a[j] == 0) {
                    StdOut.println(a[i] + " " + a[j]);
                }
            }
        }
    } 

    // return number of distinct pairs (i, j) such that a[i] + a[j] = 0
    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (a[i] + a[j] == 0) {
                    count++;
                }
            }
        }
        return count;
    } 

 /**
     * 
     * counts the number of pairs sum to exactly zero; prints out the time to perform
     * the computation along with other information.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args)  {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        Stopwatch timer = new Stopwatch();
        int count = count(a);
        double time = timer.elapsedTime();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
          //TODO: Replace with your own netid
        String netID = "tbiswas2";
          StdOut.printf("%7d %7.1f   %s  %s  %s\n", count, time, timeStamp, netID, args[0]);
    }
} 


