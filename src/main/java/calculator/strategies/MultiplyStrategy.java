package main.java.calculator.strategies;
import main.java.calculator.OperationStrategy;

public class MultiplyStrategy implements OperationStrategy {
    @Override
    public double execute(double a, double b) {
        return a * b;
    }
}