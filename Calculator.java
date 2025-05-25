package com.calculator;

public class Calculator {

    public int add(int a, int b) { return a + b; }
    public float add(float a, float b) { return a + b; }
    public ComplexNumber add(ComplexNumber a, ComplexNumber b) { return a.add(b); }

    public int subtract(int a, int b) { return a - b; }
    public float subtract(float a, float b) { return a - b; }
    public ComplexNumber subtract(ComplexNumber a, ComplexNumber b) { return a.subtract(b); }

    public int multiply(int a, int b) { return a * b; }
    public float multiply(float a, float b) { return a * b; }
    public ComplexNumber multiply(ComplexNumber a, ComplexNumber b) { return a.multiply(b); }

    public int divide(int a, int b) { return a / b; }
    public float divide(float a, float b) { return a / b; }
    public ComplexNumber divide(ComplexNumber a, ComplexNumber b) { return a.divide(b); }

    public double sin(double angle) { return Math.sin(Math.toRadians(angle)); }
    public double cos(double angle) { return Math.cos(Math.toRadians(angle)); }
    public double tan(double angle) { return Math.tan(Math.toRadians(angle)); }

    public double log(double val) { return Math.log10(val); }
    public double ln(double val) { return Math.log(val); }
}
