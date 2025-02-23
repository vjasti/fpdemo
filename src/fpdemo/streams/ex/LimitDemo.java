package fpdemo.streams.ex;

import java.util.List;

import fpdemo.streams.data.Dish;
import static java.util.stream.Collectors.toList;
public class LimitDemo {
    public static void main(String[] args) {
        List<Dish> menu = Ex1.menu;
        List<String> threeHighCalericDishNames = menu.stream()
        .filter(d -> {
            System.out.println("Filtering : "+d.getName());
            return d.getCalories() > 300;
        })
        .map(d -> {
            System.out.println("Mapping : "+d.getName());
            return d.getName();
        })
        .limit(3)
        .collect(toList());
        System.out.println(threeHighCalericDishNames);
    }
}
