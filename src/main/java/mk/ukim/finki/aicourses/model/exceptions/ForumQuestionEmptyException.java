package mk.ukim.finki.aicourses.model.exceptions;

public class ForumQuestionEmptyException extends RuntimeException{
    public ForumQuestionEmptyException() {
    }

    public ForumQuestionEmptyException(String message) {
        super(message);
    }
}
