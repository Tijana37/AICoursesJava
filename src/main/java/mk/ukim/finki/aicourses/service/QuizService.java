package mk.ukim.finki.aicourses.service;

import mk.ukim.finki.aicourses.model.Course;
import mk.ukim.finki.aicourses.model.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizService {

    List<Quiz> listAllQuizes();

    Optional<Quiz> findById(Long id);

    Quiz create(String name, Long longitude, String level, Long minPoints);

    Quiz update(Long id, String name,Long longitude, String level, Long minPoints);

    void delete(Long id);
}
