package com.can;

import java.util.Random;

public class PerformanceTest {
    static {
        System.loadLibrary("performancetest");
    }

    public native int sumArrayNative(int[] arr);

    public int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int[] createRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[10000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }
        return arr;
    }

}
