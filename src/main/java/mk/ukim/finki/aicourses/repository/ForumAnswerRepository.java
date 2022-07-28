package mk.ukim.finki.aicourses.repository;

import mk.ukim.finki.aicourses.model.ForumAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumAnswerRepository extends JpaRepository<ForumAnswer, Long> {
}
