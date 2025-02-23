package fpdemo.streams.transactions;

import java.util.Arrays;
import java.util.List;

public class TransactionDemo {
    static Trader ram = new Trader("Ram", "Hyderabad");
    static Trader krishna = new Trader("Krishna","Bengaluru");
    static Trader venkat = new Trader("Venkata","Chennai");
    static Trader sam = new Trader("Sam","Hyderabad");

    static List<Transaction> transactions = Arrays.asList(
        new Transaction(sam, 2023, 300),
        new Transaction(ram, 2024, 1000),
        new Transaction(ram, 2023, 400),
        new Transaction(krishna, 2024, 710),
        new Transaction(krishna, 2024, 700),
        new Transaction(venkat, 2024, 950)
    );
    
    public static void main(String[] args) {
        
    }

    
}
