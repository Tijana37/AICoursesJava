package mk.ukim.finki.aicourses.model.exceptions;

public class ForumNotFoundException extends RuntimeException{
    public ForumNotFoundException() {
    }

    public ForumNotFoundException(String message) {
        super(message);
    }
}
