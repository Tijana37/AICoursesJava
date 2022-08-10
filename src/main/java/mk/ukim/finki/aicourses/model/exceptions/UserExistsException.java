package mk.ukim.finki.aicourses.model.exceptions;

public class UserExistsException extends RuntimeException{
    public UserExistsException() {
    }

    public UserExistsException(String message) {
        super(message);
    }
}
