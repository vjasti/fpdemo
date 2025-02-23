package fpdemo.currying;

import java.time.LocalDate;

public class LetterBuilder {
    public static void main(String[] args) {
               
    }


    interface AddCLosing {
        Letter withClosing(String closing);
    }
    interface AddBody {
        AddCLosing withBody(String body);
    }
    interface AddSalutation {
        AddBody withSalutation(String salutation);
    }
    interface AddDateOfLetter {
        AddSalutation withDateOfLetter(LocalDate dateOfLetter);
    }
    interface AddInsideAddress {
        AddDateOfLetter withInsideAddress(String insideAddress);
    }
    interface AddReturningAddress {
        AddInsideAddress withReturningAddress(String returningAddress);
    }
}
