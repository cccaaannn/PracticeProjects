package com.can;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordGenerator {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static List<String> generate(int numberOfWords, int wordLength) {
        System.out.println(MessageFormat.format("Generating {0} words with {1} characters...", numberOfWords, wordLength));
        return IntStream.range(0, numberOfWords)
                .mapToObj(_ -> generateRandomWord(wordLength))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static String generateRandomWord(int wordLength) {
        Random random = new Random();
        StringBuilder word = new StringBuilder(wordLength);
        for (int i = 0; i < wordLength; i++) {
            word.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return word.toString();
    }
}