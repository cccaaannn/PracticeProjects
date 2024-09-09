package com.can;

public class Calculator {
    
    static {
        System.loadLibrary("calculator");
    }

    public native static double add(double a, double b);
    public native static double subtract(double a, double b);
    public native static double multiply(double a, double b);
    public native static double divide(double a, double b);
}
