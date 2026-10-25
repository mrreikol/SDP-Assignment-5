package main.java.calculator;

import main.java.calculator.strategies.AddStrategy;
import main.java.calculator.strategies.MultiplyStrategy;
import main.java.calculator.strategies.SubtractStrategy;

public class Main {
    public static void main(String[] args) {
        double a = 12.0;
        double b = 4.0;

        Calculator calculator = new Calculator(new AddStrategy());

        System.out.println("Strategy Calculator");
        System.out.println("Operands: " + a + " and " + b);
        System.out.println();

        System.out.println("Selected strategy: Addition");
        System.out.println("Result: " + calculator.calculate(a, b));

        calculator.setStrategy(new SubtractStrategy());

        System.out.println("Switching strategy to Subtraction...");
        System.out.println("Result: " + calculator.calculate(a, b));

        calculator.setStrategy(new MultiplyStrategy());

        System.out.println("Switching strategy to Multiplication...");
        System.out.println("Result: " + calculator.calculate(a, b));
    }
}