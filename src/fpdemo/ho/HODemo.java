package fpdemo.ho;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import static java.util.Comparator.comparing;

import fpdemo.bp.Apple;

public class HODemo {
    public static void main(String[] args) {
        Function<Double, Double> half = x -> x/2;
        System.out.println(applyFunction(10.0, half));

         List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        inventory.sort(comparing(Apple::getWeight).reversed());
        System.out.println(inventory);
    }

    public static Double applyFunction(Double x, Function<Double, Double> f) {
        return f.apply(x);

    }

}
