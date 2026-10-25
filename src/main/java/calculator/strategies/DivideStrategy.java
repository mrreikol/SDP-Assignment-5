package main.java.calculator.strategies;

import main.java.calculator.OperationStrategy;

public class DivideStrategy implements OperationStrategy {
    @Override
    public double execute(double a, double b) {
        if (b == 0.0) {
            throw new ArithmeticException(
                    "Division by zero is not allowed."
            );
        }

        return a / b;
    }
}