package fpdemo.streams.ex;

import java.util.stream.Stream;

public class IterateDemo {
    public static void main(String[] args) {
       Stream.iterate(new int[] {0,1}, 
                    t -> new int[] {t[1], t[0]+t[1]})
                    .map(t -> t[0]+",")
                    .limit(10)
                    .forEach(System.out::print);

    }
}
