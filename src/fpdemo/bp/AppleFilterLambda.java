package fpdemo.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AppleFilterLambda {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> result = filterApples(inventory, (apple) -> "green".equals(apple.getColor()));
        System.out.println(result);

        result = filterApples(inventory, AppleFilterLambda::isHeaveyApple);
        System.out.println(result);
        
    }

    public static boolean isHeaveyApple(Apple a) {
        return a.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}

