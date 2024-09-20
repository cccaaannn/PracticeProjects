package com.can;

import java.text.MessageFormat;

public class Main {
    public static void main(String[] args) {

        PerformanceTest test = new PerformanceTest();

        long totalJavaTime = 0;
        long totalNativeTime = 0;
        int iterations = 100;

        for (int i = 0; i < iterations; i++) {
            int[] arr = PerformanceTest.createRandomArray(10000000);

            long start = System.currentTimeMillis();
            test.sumArray(arr);
            long end = System.currentTimeMillis();

            long startNative = System.currentTimeMillis();
            test.sumArrayNative(arr);
            long endNative = System.currentTimeMillis();

            totalJavaTime += end - start;
            totalNativeTime += endNative - startNative;
        }

        System.out.println(MessageFormat.format("Java: {0} ms", totalJavaTime / iterations));

        System.out.println(MessageFormat.format("C++ with JNI: {0} ms", totalNativeTime / iterations));

    }
}
