package com.abruzese.ThreeSumExtraFast;

import com.abruzese.StdOut;

public class ThreeSumExtraFast {

    // Do not instantiate.
    private ThreeSumExtraFast() { }

    public static void printAll(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                    }
                }
            }
        }
    } 

    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        boolean[] set = new boolean[1000000];
        for (int k : a) {
            set[k] = true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(set[-a[i]-a[j]]) count++;
            }
        }
        return count;
    }
} 

