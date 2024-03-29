package mk.ukim.finki.aicourses.service;

import mk.ukim.finki.aicourses.model.Course;
import mk.ukim.finki.aicourses.model.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizService {

    List<Quiz> listAllQuizes();

    Optional<Quiz> findById(Long id);

    Quiz create(String name, Long longitude, String level, Long minPoints, Long totalTrueAnswers);

    Quiz update(Long id, String name, Long longitude, String level, Long minPoints);

    void delete(Long id);

    Optional<Quiz> findByName(String name);

    double isPassed(String quizName, String[] checkboxValues);
    
    //changes for Heroku
     double isPassedWithId(Long quizId, String[] checkboxValues);
}
