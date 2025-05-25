package com.calculator;

public class Main {
    public static void main(String[] args) {
        DatabaseManager.initializeDatabase();

        Calculator calc = new Calculator();

        int result1 = calc.add(5, 3);
        System.out.println("Int Add: " + result1);
        DatabaseManager.logOperation("int", "add", "5", "3", Integer.toString(result1));

        float result2 = calc.multiply(2.5f, 4.0f);
        System.out.println("Float Multiply: " + result2);
        DatabaseManager.logOperation("float", "multiply", "2.5", "4.0", Float.toString(result2));

        ComplexNumber c1 = new ComplexNumber(3, 2);
        ComplexNumber c2 = new ComplexNumber(1, 4);
        ComplexNumber cResult = calc.multiply(c1, c2);
        System.out.println("Complex Multiply: " + cResult);
        DatabaseManager.logOperation("complex", "multiply", c1.toString(), c2.toString(), cResult.toString());

        double result3 = calc.sin(90);
        System.out.println("Sin(90): " + result3);
        DatabaseManager.logOperation("float", "sin", "90", "", Double.toString(result3));

        DatabaseManager.printHistory();
    }
}
