package fpdemo.streams.ex;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import fpdemo.streams.data.Dish;

public class ReduceDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        int sum = 0;
        for(int x : numbers) {
            sum += x;
        }
        System.out.println(sum);
        int sum2 = numbers.stream()
            .reduce(0, (a, b) -> a + b);
        System.out.println(sum2);

        int sum3 = numbers.stream()
            .reduce(0, Integer::sum);
        System.out.println(sum3);

        Optional<Integer> sum4 = numbers.stream()
            .reduce(Integer::sum);
        System.out.println(sum4.orElse(0));

        Optional<Integer> max = numbers.stream()
            .reduce(Integer::max);
        System.out.println(max.orElse(0));

        Optional<Integer> min = numbers.stream()
            .reduce(Integer::min);
        System.out.println(min.orElse(0));

        List<Dish> menu = Ex1.menu;

        int totalCalories = menu.stream()
            .map(Dish::getCalories)
            .reduce(0, Integer::sum);
        System.out.println("Total calories: "+totalCalories);
 
    }
}
