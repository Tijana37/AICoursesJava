package mk.ukim.finki.aicourses.repository;

import mk.ukim.finki.aicourses.model.UserQuiz;
import mk.ukim.finki.aicourses.model.UserQuizCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserQuizRepository extends JpaRepository<UserQuiz, UserQuizCompositeKey> {
}
