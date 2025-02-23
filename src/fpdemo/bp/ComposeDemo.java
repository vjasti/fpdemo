package fpdemo.bp;
import java.util.function.Function;

public class ComposeDemo {
    public static void main(String[] args) {
      
        Function<Integer, Integer> adder = x -> x+1;
        Function<Integer, Integer> multiplier = x -> x*2;

        Function<Integer, Integer> addThenMultiply = adder.andThen(multiplier);
        System.out.println(addThenMultiply.apply(2));
        
        Function<Integer, Integer> f2 = adder.compose(multiplier);
        System.out.println(f2.apply(2));
        
    }
}
