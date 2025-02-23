package fpdemo.streams.ex;

import java.util.List;

import fpdemo.streams.data.Dish;

public class SkipDemo {
    public static void main(String[] args) {
        List<Dish> menu = Ex1.menu;
        menu.stream()
            .filter(d -> d.getCalories() > 300)
            .skip(2)
            .forEach(System.out::println);

    }
}
