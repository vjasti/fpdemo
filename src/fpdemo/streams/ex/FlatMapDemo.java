package fpdemo.streams.ex;

import java.util.Arrays;
import java.util.List;

public class FlatMapDemo {
    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
        // List<Integer> squares = numbers1.stream()
        //     .map(n -> n * n)
        //     .toList();
        // System.out.println(squares);
       
        List<Integer> numbers2 = Arrays.asList(6,7,8,9,10);       
        // List<int[]> pairs = numbers1.stream()
        //     .flatMap(i -> numbers2.stream()
        //         .map(j -> new int[]{i, j}))
        //     .toList();
        // pairs.stream().forEach(t -> System.out.println(t[0]+", "+t[1]));

        List<int[]> pairs2 = numbers1.stream()
            .flatMap(i -> numbers2.stream()
                .filter(j -> (i + j) % 3 == 0)
                .map(j -> new int[]{i, j}))
            .toList();
            pairs2.stream().forEach(t -> System.out.println(t[0]+", "+t[1]));
   }
}
