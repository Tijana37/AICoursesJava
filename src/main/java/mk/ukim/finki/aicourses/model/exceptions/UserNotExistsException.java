package mk.ukim.finki.aicourses.model.exceptions;

public class UserNotExistsException extends RuntimeException{
    public UserNotExistsException() {
    }

    public UserNotExistsException(String message) {
        super(message);
    }
}
