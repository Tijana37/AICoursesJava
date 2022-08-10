package mk.ukim.finki.aicourses.model.exceptions;

public class ExperienceFormEmptyException extends RuntimeException {
    public ExperienceFormEmptyException() {
    }

    public ExperienceFormEmptyException(String message) {
        super(message);
    }
}
