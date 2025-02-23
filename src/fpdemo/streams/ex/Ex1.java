package fpdemo.streams.ex;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fpdemo.streams.data.Dish;

public class Ex1 {
    public static List<Dish> menu;
    static {
        menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
        );
    }
    public static void main(String[] args) {
        //filterjava7way();
        filterjava8way();
    }

    public static void filterjava7way () {
        List<Dish> lowcaloricDishs = new ArrayList<>();
        
        // Filtering dishes with less than 400 calories using explicit iteration and an accumulator
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowcaloricDishs.add(dish);
            }
        }

        // Sorting the lowcaloricDishs by calories with an anonymous class
        Collections.sort(lowcaloricDishs, new Comparator<Dish>(){
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });

        // Extracting the names of the lowcaloricDishs
        List<String> lowCaloricDishNames = new ArrayList<>();
        for (Dish dish : lowcaloricDishs) {
            lowCaloricDishNames.add(dish.getName());
        }

        System.out.println(lowCaloricDishNames);

    }

    private static void filterjava8way() {
        List<String> lowCaloricDishNames = menu.stream()
            .filter(d -> d.getCalories() < 400) // filter the dishes with less than 400 calories
            .sorted(Comparator.comparing(Dish::getCalories)) // sort them by calories
            .map(Dish::getName) // extract the names of the dishes
            .collect(toList()); // collect the names into a list

        System.out.println(lowCaloricDishNames);
    }



    public static void printDishes(List<Dish> dishes) {
        for (Dish dish : dishes) {
            System.out.println(dish);
        }
    }
    
}
