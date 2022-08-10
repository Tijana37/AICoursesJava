package mk.ukim.finki.aicourses.model.exceptions;

public class CourseIdException extends RuntimeException{
    public CourseIdException() {
    }

    public CourseIdException(String message) {
        super(message);
    }
}
