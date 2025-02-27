package fpdemo.currying;

import java.util.function.BiFunction;
import java.util.function.Function;

public class PADemo {

    public static int add(int x, int y) {
        return x+y;
    }

    public static int add3(int x, int y, int z) {
        return x+y+z;
    }

    public static <T,U, R> Function<U, R> partial (BiFunction<T, U, R> f, T x ) {
        return (y) -> f.apply(x, y);
    }

    public static <T,U, V, R> Function<V, R> partial (TriFunction<T, U, V, R> f, T x, U y ) {
        return (z) -> f.apply(x, y, z);
    }

    public static <T,U, V, R> BiFunction<U, V, R> partial (TriFunction<T, U, V, R> f, T x) {
        return (y, z) -> f.apply(x, y, z);
    }

    public static void main(String[] args) {
        Function<Integer, Integer> adder = partial(PADemo::add, 10);
        System.out.println(adder.apply(5));

        Function<Integer, Integer> adder2 = partial(PADemo::add3, 10, 5);
        System.out.println(adder2.apply(3));

        BiFunction<Integer, Integer, Integer> adder3 = partial(PADemo::add3, 10);
        System.out.println(adder3.apply(10, 5));
    }
}