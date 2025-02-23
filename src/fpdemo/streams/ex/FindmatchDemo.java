package fpdemo.streams.ex;

import java.util.List;
import java.util.Optional;

import fpdemo.streams.data.Dish;

public class FindmatchDemo {
    public static void main(String[] args) {
        List<Dish> menu = Ex1.menu;
        // anyMatch (Predicate p)
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
        // allMatch (Predicate p)
        boolean isHealthy = menu.stream().allMatch(d -> d.getCalories() < 1000);
        System.out.println("Is the menu healthy? "+isHealthy);

        // noneMatch (Predicate p)
        boolean isHealthy2 = menu.stream().noneMatch(d -> d.getCalories() >= 1000);
        System.out.println("Is the menu healthy? "+isHealthy2);

        // findAny ()
        Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();
        dish.ifPresent(System.out::println);
        boolean isPresent = dish.isPresent();
        System.out.println("Is there a vegetarian dish? "+isPresent);
        if(isPresent) {
            System.out.println("The vegetarian dish is: "+dish.get());
        }
    }
}
