package fpdemo.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleFilter {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        List<Apple> result = filterApples(inventory, new AppleColorPredicate("green"));
        System.out.println(result);
        result = filterApples(inventory, new AppleHeavyWeightPredicate());
        System.out.println(result);
    }
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}
interface ApplePredicate {
    boolean test(Apple apple);
}

class AppleHeavyWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}

class AppleColorPredicate implements ApplePredicate {
    private String color;
    public AppleColorPredicate(String color) {
        this.color = color;
    }
    public boolean test(Apple apple) {
        return color.equals(apple.getColor());
    }
}
