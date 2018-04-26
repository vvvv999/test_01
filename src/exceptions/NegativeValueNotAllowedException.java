package exceptions;

import java.util.InputMismatchException;

public class NegativeValueNotAllowedException extends Exception {

    public NegativeValueNotAllowedException() {

        //had to use "out" instead of "err" to keep streams synchronized; err.flush() didn't solve the problem
        System.out.println("ERROR: Negative values are not allowed here");

    }

    public NegativeValueNotAllowedException(String s) {
        super(s);
    }

}