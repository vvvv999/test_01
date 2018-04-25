package exceptions;

import java.util.InputMismatchException;

public class NegativeValueNotAllowedException extends Exception {


    public NegativeValueNotAllowedException() {
        System.out.println("Negative values are not allowed here"); //had to use "out" instead of "err" for printed outputs to be synchronized; err.flush() didn't solve the problem

    }


    public NegativeValueNotAllowedException(String s) {
        super(s);
    }

}