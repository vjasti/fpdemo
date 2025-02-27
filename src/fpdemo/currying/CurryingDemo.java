package fpdemo.currying;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class CurryingDemo {
    public static void main(String[] args) {
        Supplier<Integer> random = () -> new Random().nextInt();
        System.out.println(random.get());

        Function<Integer,Integer> addToRandom = x -> x + random.get();
        System.out.println(addToRandom.apply(5));

        BiFunction<Integer, Integer, Integer> biAdder = (x, y) -> x+y;
        System.out.println(biAdder.apply(10, 5));

        TriFunction<Integer, Integer,Integer,Integer> triAdder = (x,y,z) -> x+y+z;
        System.out.println(triAdder.apply(10, 5, 3));

        Function<Integer, Function<Integer, Function<Integer, Integer>>> curryingFunction = x -> y -> z -> x+y+z;
        System.out.println(curryingFunction.apply(10).apply(5).apply(3));   
        
    }




}

interface TriFunction<T,U,V,R> {
    R apply(T x,U y,V z);
}
