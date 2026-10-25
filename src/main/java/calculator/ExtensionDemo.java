package main.java.calculator;

import main.java.calculator.strategies.AddStrategy;
import main.java.calculator.strategies.DivideStrategy;

public class ExtensionDemo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new AddStrategy());

        System.out.println("Extension Demonstration");

        System.out.println("Initial strategy: Addition");
        System.out.println(
                "12.0 + 4.0 = " + calculator.calculate(12.0, 4.0)
        );

        calculator.setStrategy(new DivideStrategy());

        System.out.println("Switching strategy to Division...");
        System.out.println(
                "12.0 / 4.0 = " + calculator.calculate(12.0, 4.0)
        );

        System.out.println("Testing division by zero...");

        try {
            System.out.println(
                    "Result: " + calculator.calculate(12.0, 0.0)
            );
        } catch (ArithmeticException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}