package exceptions;

public class CarsListIsEmptyException extends Exception {

    public CarsListIsEmptyException() {

        //had to use "out" instead of "err" for sake of consistency, see the prime cause in NegativeValueNotAllowedException class.
        System.out.println("ERROR: Your cars list is empty");

    }

    public CarsListIsEmptyException(String message) {
        super(message);
    }

    public CarsListIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarsListIsEmptyException(Throwable cause) {
        super(cause);
    }

    public CarsListIsEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
