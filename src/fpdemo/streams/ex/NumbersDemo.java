package fpdemo.streams.ex;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumbersDemo {
    public static void main(String[] args) {
        Stream<double[]> triples  = 
            IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> 
                    IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a*a + b*b)})
                        .filter(t -> t[2] % 1 == 0));

        triples.limit(5).forEach(t -> System.out.println(t[0]+", "+t[1]+", "+t[2]));
    }
}
