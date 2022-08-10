package mk.ukim.finki.aicourses.model.exceptions;

public class ExperienceNotFoundException extends RuntimeException{
    public ExperienceNotFoundException() {
    }

    public ExperienceNotFoundException(String message) {
        super(message);
    }
}
