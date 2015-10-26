package tutorial.core.services.exceptions;

public class BlogNotFoundException extends RuntimeException {


    public BlogNotFoundException() {
    }

    public BlogNotFoundException(String message) {
        super(message);
    }

    public BlogNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

//    public BlogNotFoundException(Throwable cause) {
//        super(cause);
//    }
}
