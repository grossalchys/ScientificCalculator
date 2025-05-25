package com.calculator;

public class ComplexNumber {
    double real;
    double imag;

    public ComplexNumber(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imag + other.imag);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imag - other.imag);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double r = this.real * other.real - this.imag * other.imag;
        double i = this.real * other.imag + this.imag * other.real;
        return new ComplexNumber(r, i);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imag * other.imag;
        double r = (this.real * other.real + this.imag * other.imag) / denominator;
        double i = (this.imag * other.real - this.real * other.imag) / denominator;
        return new ComplexNumber(r, i);
    }

    @Override
    public String toString() {
        return String.format("%.2f + %.2fi", real, imag);
    }
}
