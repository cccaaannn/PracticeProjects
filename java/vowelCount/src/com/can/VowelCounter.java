package com.can;

import java.util.List;
import java.util.Map;

public class VowelCounter {

    private static final long VOWEL_BITMAP = 
            0b000000000000000000000000000000000000000000000000000000001L | // A
            0b000000000000000000000000000000000000000000000000000010000L | // E
            0b000000000000000000000000000000000000000000000000100000000L | // I
            0b000000000000000000000000000000000000000000100000000000000L | // O
            0b000000000000000000000000000000000000100000000000000000000L | // U
            0b000000000000000000000000100000000000000000000000000000000L | // a
            0b000000000000000000001000000000000000000000000000000000000L | // e
            0b000000000000000010000000000000000000000000000000000000000L | // i
            0b000000000010000000000000000000000000000000000000000000000L | // o
            0b000010000000000000000000000000000000000000000000000000000L; // u

    // Ascii characters from 65 to 122
    private static final String VALID_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz";

    private final long charToMaskArray[] = new long[VALID_CHARS.length()];
    private final Map<Character, Long> charToMaskMap = new java.util.HashMap<>();

    private void precomputeMasks() {
        for (int i = 0; i < VALID_CHARS.length(); i++) {
            char c = VALID_CHARS.charAt(i);
            long mask = 1L << (c - 'A');
            charToMaskArray[i] = mask;
            charToMaskMap.put(c, mask);
        }
    }

    VowelCounter() {
        precomputeMasks();
    }

    private int hasVowelCalc(String s) {
        long combinedMask = 0;
        for (int i = 0; i < s.length(); i++) {

            // Create a bit mask for the character
            // Example bit mask for A 0b00000000000000000000000000000001
            long mask = 1L << (s.charAt(i) - 'A');

            // Combined mask of the whole word
            combinedMask |= mask;
        }

        // No if statement, no branching
        // return (int) ((VOWEL_BITMAP & combinedMask) != 0 ? 1 : 0);
        return Long.signum(VOWEL_BITMAP & combinedMask);
    }

    private int hasVowelLookupArray(String s) {
        long combinedMask = 0;
        for (int i = 0; i < s.length(); i++) {
            long mask = charToMaskArray[s.charAt(i) - 'A'];
            combinedMask |= mask;
        }

        return Long.signum(VOWEL_BITMAP & combinedMask);
    }

    private int hasVowelLookupMap(String s) {
        long combinedMask = 0;
        for (int i = 0; i < s.length(); i++) {
            long mask = charToMaskMap.get(s.charAt(i));
            combinedMask |= mask;
        }

        return Long.signum(VOWEL_BITMAP & combinedMask);
    }

    public int countMaskCalc(List<String> lines) {
        int count = 0;
        for (String line : lines) {
            count += hasVowelCalc(line);
        }
        return count;
    }

    public int countMaskLookup(List<String> lines) {
        int count = 0;
        for (String line : lines) {
            count += hasVowelLookupArray(line);
        }
        return count;
    }

    public int countMaskMap(List<String> lines) {
        int count = 0;
        for (String line : lines) {
            count += hasVowelLookupMap(line);
        }
        return count;
    }

    public int countRegular(List<String> lines) {
        return lines.stream()
                .filter(
                        line -> line.toLowerCase().chars().anyMatch(c -> "aeiou".indexOf(c) >= 0))
                .toArray().length;
    }

}
