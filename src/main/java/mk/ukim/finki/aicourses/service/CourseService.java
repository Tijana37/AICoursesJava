package mk.ukim.finki.aicourses.service;

import mk.ukim.finki.aicourses.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> listAllCourses();

    Optional<Course> findById(Long id);

    Course create(String name, Long longitude, String teacher, String level, Long suggestedQuiz);

    Course update(Long id, String name,Long longitude, String teacher, String level);

    Course delete(Long id);

}
