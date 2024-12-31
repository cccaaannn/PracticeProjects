package com.can;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<String> lines = WordGenerator.generate(10_000_000, 5);
        // List<String> lines = WordGenerator.generate(10_000_000, 50);

        var counter = new VowelCounter();

        System.out.println("Counting words with vowels...");

        var start = System.currentTimeMillis();
        var count = counter.countRegular(lines);
        var end = System.currentTimeMillis();
        System.out.println(MessageFormat.format("Baseline: {0} vowels in {1} ms", count, (end - start)));

        start = System.currentTimeMillis();
        count = counter.countMaskCalc(lines);
        end = System.currentTimeMillis();
        System.out.println(MessageFormat.format("Bit mask realtime: {0} vowels in {1} ms", count, (end - start)));

        start = System.currentTimeMillis();
        count = counter.countMaskLookup(lines);
        end = System.currentTimeMillis();
        System.out.println(MessageFormat.format("Bit mask lookup array: {0} vowels in {1} ms", count, (end - start)));

        start = System.currentTimeMillis();
        count = counter.countMaskMap(lines);
        end = System.currentTimeMillis();
        System.out.println(MessageFormat.format("Bit mask lookup map: {0} vowels in {1} ms", count, (end - start)));
    }

}
