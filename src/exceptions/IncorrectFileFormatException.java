package exceptions;

public class IncorrectFileFormatException extends Exception {

    public IncorrectFileFormatException() {
        //had to use "out" instead of "err" for sake of consistency, see the prime cause in NegativeValueNotAllowedException class.
        System.out.println("ERROR: Incorrect file format! Only .txt or .csv files are acceptable");
    }

    public IncorrectFileFormatException (String message) {
        super(message);
    }

    public IncorrectFileFormatException (String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectFileFormatException (Throwable cause) {
        super(cause);
    }

    public IncorrectFileFormatException (String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
