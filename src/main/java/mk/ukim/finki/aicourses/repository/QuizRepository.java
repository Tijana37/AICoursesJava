package mk.ukim.finki.aicourses.repository;

import mk.ukim.finki.aicourses.model.Course;
import mk.ukim.finki.aicourses.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Optional<Quiz> findByName(String name);
}
