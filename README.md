# Calculator Using the Strategy Design Pattern

A Java 17 console application that uses interchangeable strategies for arithmetic operations. The same calculator can change its operation at runtime.

## Project Structure

```text
SDP-Assignment-5/
├── README.md
└── src/main/java/calculator/
    ├── OperationStrategy.java
    ├── Calculator.java
    ├── Main.java
    ├── ExtensionDemo.java
    └── strategies/
        ├── AddStrategy.java
        ├── SubtractStrategy.java
        ├── MultiplyStrategy.java
        └── DivideStrategy.java
```

## Build and Run

Open a terminal in the `strategy-calculator` directory. Check that `java -version` and `javac -version` report version 17 or later.

Compile:

```bash
javac --release 17 -d out src/main/java/calculator/*.java src/main/java/calculator/strategies/*.java
```

Run the runtime-switching demonstration:

```bash
java -cp out calculator.Main
```

Run the extension and error-handling demonstration:

```bash
java -cp out calculator.ExtensionDemo
```

In IntelliJ IDEA, open the project, select JDK 17, mark `src/main/java` as Sources Root if necessary, and run `Main` or `ExtensionDemo`.

## Expected Output

`Main`:

```text
Strategy Calculator
Operands: 12.0 and 4.0

Selected strategy: Addition
Result: 16.0
Switching strategy to Subtraction...
Result: 8.0
Switching strategy to Multiplication...
Result: 48.0
```

`ExtensionDemo`:

```text
Extension Demonstration
Initial strategy: Addition
12.0 + 4.0 = 16.0
Switching strategy to Division...
12.0 / 4.0 = 3.0
Testing division by zero...
Error: Division by zero is not allowed.
```

## Pattern Roles

| Component | Role | Responsibility |
| --- | --- | --- |
| `OperationStrategy` | Strategy interface | Defines `execute(double a, double b)`. |
| Arithmetic strategy classes | Concrete Strategies | Implement individual arithmetic algorithms. |
| `Calculator` | Context | Stores a strategy and delegates calculation. |
| `Main`, `ExtensionDemo` | Clients | Select strategies and display results. |

`Calculator.calculate` calls `strategy.execute(a, b)`. It contains no operation-selection conditionals and does not depend on concrete strategy classes. Both clients demonstrate switching on an existing calculator instance.

## Adding a New Strategy

1. Create a class in `calculator.strategies` that implements `OperationStrategy`.
2. Implement `execute(double a, double b)`.
3. Instantiate the class in a client and pass it to the constructor or `setStrategy`.
4. Recompile and run the client.

`DivideStrategy` and `ExtensionDemo` demonstrate this extension approach. They can be added without editing `Calculator`, `OperationStrategy`, `Main`, or the original arithmetic strategies. Future operations follow the same steps; new client configuration may be needed.