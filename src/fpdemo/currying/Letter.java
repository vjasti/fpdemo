package fpdemo.currying;

import java.time.LocalDate;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Letter {
    private String returningAddress;
    private String insideAddress;
    private LocalDate dateOfLetter;
    private String salutation;
    private String body;
    private String closing;

    public Letter() {
        this(null, null, LocalDate.now(), "", null, null);
    }

    public Letter(String salutation) {
        this(null, null, LocalDate.now(), salutation, null, null);
    }

    public Letter(String salutation, String body) {
        this(null, null, LocalDate.now(), salutation, body, null);
    }

    public Letter(String returningAddress, String insideAddress, LocalDate dateOfLetter, String salutation, String body,
            String closing) {
        this.returningAddress = returningAddress;
        this.insideAddress = insideAddress;
        this.dateOfLetter = dateOfLetter;
        this.salutation = salutation;
        this.body = body;
        this.closing = closing;
    }

    public static void main(String[] args) {
        Letter l1 = new Letter("Mr", "testing");
        System.out.println(l1);

        Supplier<Letter> f1 = Letter::new;
        System.out.println(f1.get());

        Function<String, Letter> f2 = Letter::new;
        System.out.println(f2.apply("Mrs"));

        BiFunction<String, String, Letter> f3 = Letter::new;
        System.out.println(f3.apply("Mr", "testing"));

        Function<String, Function<String, Letter>> f4 = salutation -> body -> new Letter(salutation, body);
        System.out.println(f4.apply("Mr").apply("testing"));

        Function<String, Function<String, Function<LocalDate, Function<String, Function<String, Function<String, Letter>>>>>> LETTER_CREATOR = returningAddress -> insideAddress -> dateOfLetter -> salutation -> body -> closing -> new Letter(
                returningAddress, insideAddress, dateOfLetter, salutation, body, closing);

        Letter l2 = LETTER_CREATOR
                .apply("abc")
                .apply("xyz")
                .apply(LocalDate.now())
                .apply("Mr")
                .apply("testing")
                .apply("Thanks");
        System.out.println(l2);

    }

    @Override
    public String toString() {
        return "Letter [returningAddress=" + returningAddress + ", insideAddress=" + insideAddress + ", dateOfLetter="
                + dateOfLetter + ", salutation=" + salutation + ", body=" + body + ", closing=" + closing + "]";
    }

}
