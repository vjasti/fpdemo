package fpdemo.streams.ex;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;


public class MapDemo {
    public static void main(String[] args) {
       List<String> words = Arrays.asList( "Hello", "World", "Java", "Streams");
    //    List<Integer> wordLengths = words.stream()
    //         .map(String::length)
    //         .collect(java.util.stream.Collectors.toList());
    //     System.out.println(wordLengths);
       List<String> letters = words.stream()
            .map(word -> word.split(""))
            .flatMap(Arrays::stream)
            .distinct()
            .collect(toList());
        System.out.println(letters);
    }
}
