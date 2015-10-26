package tutorial.core.services.exceptions;

public class AccountExistsException extends RuntimeException {


    public AccountExistsException() {
    }

    public AccountExistsException(String message) {
        super(message);
    }

    public AccountExistsException(String message, Throwable cause) {
        super(message, cause);
    }

//    public AccountExistsException(Throwable cause) {
//        super(cause);
//    }
}
