package errorHandling;

/**
 * Created by sourabh.su on 21/01/17.
 */
public class CustomException extends Exception {

    public CustomException(String errorMessage) { super(errorMessage);}

    public CustomException (String errorMessage, Throwable throwable ) {
        super(errorMessage, throwable);
    }
}
