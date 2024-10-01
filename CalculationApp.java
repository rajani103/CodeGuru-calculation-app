package com.example;

import java.util.ArrayList;
import java.util.List;
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

        // Generating a list of prime numbers (inefficient)
        logger.info("Generating prime numbers up to 100...");
        List<Integer> primes = app.generatePrimes(100);
        logger.info("Generated primes: " + primes);

        // Intentional infinite loop to showcase profiling
        logger.info("Starting infinite loop (press Ctrl+C to stop)...");
        app.infiniteLoop();
    }

    // Inefficient method to calculate factorial using recursion
    public long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative input: " + n);
        }
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1); // Recursive method can be inefficient for larger numbers
        }
    }

    // Inefficient method to check for prime numbers
    public boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) { // Improved but still inefficient
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Inefficient method to generate a list of prime numbers
    public List<Integer> generatePrimes(int limit) {
        List<Integer> primes = new ArrayList<>();
        for (int num = 2; num <= limit; num++) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        return primes; // Could be optimized with better algorithms
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
