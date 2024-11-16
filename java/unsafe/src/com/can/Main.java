package com.can;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        int size = 10;

        try (UnsafeArray<Integer> unsafeArray = new UnsafeArray<Integer>(size, Integer.class)) {
            for (int i = 0; i < size; i++) {
                unsafeArray.set(i, i);
            }

            for (int i = 0; i < unsafeArray.size(); i++) {
                System.out.println(unsafeArray.get(i));
            }
        }

        try (UnsafeArray<String> unsafeArray = new UnsafeArray<String>(size, String.class)) {
            for (int i = 0; i < size; i++) {
                unsafeArray.set(i, "Hello world! " + i);
            }

            for (int i = 0; i < unsafeArray.size(); i++) {
                System.out.println(unsafeArray.get(i));
            }
        }

    }
}
