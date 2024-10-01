package com.example;

import java.util.logging.Logger;

public class CalculationApp {
    private static final Logger logger = Logger.getLogger(CalculationApp.class.getName());

    public static void main(String[] args) {
        CalculationApp app = new CalculationApp();

        // Inefficient Factorial Calculation
        logger.info("Calculating factorial of 10...");
        long factorialResult = app.calculateFactorial(10);
        logger.info("Factorial of 10 is: " + factorialResult);

        // Checking if a number is prime
        int num = 29;
        logger.info("Checking if " + num + " is a prime number...");
        boolean isPrime = app.isPrime(num);
        logger.info(num + " is a prime number: " + isPrime);

        // Intentional infinite loop to showcase profiling
        logger.info("Starting infinite loop (press Ctrl+C to stop)...");
        app.infiniteLoop();
    }

    // Inefficient method to calculate factorial
    public long calculateFactorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1); // Recursive method can be inefficient for larger numbers
        }
    }

    // Inefficient method to check for prime numbers
    public boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Intentional infinite loop to test profiling
    public void infiniteLoop() {
        while (true) {
            try {
                Thread.sleep(1000); // Sleep for a second
            } catch (InterruptedException e) {
                logger.warning("Thread interrupted!");
            }
        }
    }
}
