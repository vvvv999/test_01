package exceptions;

import java.util.InputMismatchException;

public class NegativeValueNotAllowedException extends InputMismatchException {


    public NegativeValueNotAllowedException() {
        System.out.println("Negative values not allowed here"); //had to use "out" instead of "err" for printed outputs to be synchronized

    }


    public NegativeValueNotAllowedException(String s) {
        super(s);
    }

}