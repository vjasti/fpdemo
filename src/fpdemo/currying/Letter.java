package fpdemo.currying;

import java.time.LocalDate;

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

    }

    @Override
    public String toString() {
        return "Letter [returningAddress=" + returningAddress + ", insideAddress=" + insideAddress + ", dateOfLetter="
                + dateOfLetter + ", salutation=" + salutation + ", body=" + body + ", closing=" + closing + "]";
    }

}
