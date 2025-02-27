package fpdemo.currying;

import java.time.LocalDate;

public class LetterBuilder {
    public static void main(String[] args) {
        Letter l3 = builder()
                        .withReturningAddress("retAddr")
                        .withInsideAddress("inside")
                        .withDateOfLetter(LocalDate.now())
                        .withSalutation("Mr")
                        .withBody("testing")
                        .withClosing("Thank You");
        System.out.println(l3);
        
    }

   static AddReturningAddress builder() {
        return returningAddress 
                    -> insideAddress 
                    -> dateOfLetter 
                    -> salutation 
                    -> body 
                    -> closing 
                    -> new Letter(returningAddress, insideAddress, dateOfLetter, salutation, body, closing);
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
