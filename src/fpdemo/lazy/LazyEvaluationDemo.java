package fpdemo.lazy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LazyEvaluationDemo {
    public static void main(String[] args) {
        Supplier<Integer> random = () -> {
            System.out.println("Generating random number");
            return (int) (Math.random() * 100);
        };
        // System.out.println(random.get());
        // System.out.println(random.get());
        // System.out.println(random.get());

        List<String> strings = Arrays.asList("one","two","three", "four", "five");
        Stream<String> longStringsStream = strings.stream()
               
                .filter(s -> {
                    System.out.println("Filtering: " + s);
                    return s.length() > 3;
                })
                .map(s -> {
                    System.out.println("Mapping: " + s);
                    return s.toUpperCase();
                })
                .limit(1);
        System.out.println("Stream created, filter not applied yet!");
        longStringsStream.forEach(s -> System.out.println(s));
    }
}
