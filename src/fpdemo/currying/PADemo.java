package fpdemo.currying;

import java.util.function.BiFunction;
import java.util.function.Function;

public class PADemo {

    public static int add(int x, int y) {
        return x + y;
    }

    public static int add3(int x, int y, int z) {
        return x + y + z;
    }

    public static <T, U, R> Function<U, R> partial(BiFunction<T, U, R> f, T x) {
        return (y) -> f.apply(x, y);
    }

    public static void main(String[] args) {

    }
}