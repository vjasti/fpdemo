package fpdemo.streams.ex;

import java.util.function.IntSupplier;

public class GenerateDemo {
    public static void main(String[] args) {
        // java.util.stream.Stream.generate(Math::random)
        //     .limit(5)
        //     .forEach(System.out::println);
        
        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;
            public int getAsInt() {
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return this.previous;
            }
        };
        java.util.stream.IntStream.generate(fib)
            .limit(10)
            .forEach(System.out::println);

    }
}
