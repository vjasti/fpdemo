package fpdemo.recursive;

import java.util.stream.LongStream;

public class RecursionDemo {
    public static void main(String[] args) {
        System.out.println(factorialIterative(5));
        System.out.println(factorialRecursive(5));
        System.out.println(factorialTailRecursive(5));
        System.out.println(factorialStreams(5));
    }
    public static int factorialIterative(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    public static long factorialRecursive(long n) {
        return (n == 1) ? 1 : n * factorialRecursive(n - 1);
    }

    public static long factorialTailRecursive(long n) {
        return factorialHelper(n, 1);
    }
    public static long factorialHelper(long n, long acc) {
        return (n == 1) ? acc : factorialHelper(n - 1, n * acc);
    }   

    public static long factorialStreams(long n) {
        return LongStream.rangeClosed(1, n)
                            .reduce(1, (long a, long b) -> a * b);
    }


}
