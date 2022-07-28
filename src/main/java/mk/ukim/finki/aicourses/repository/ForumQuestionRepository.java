package mk.ukim.finki.aicourses.repository;
import mk.ukim.finki.aicourses.model.ForumQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumQuestionRepository extends JpaRepository<ForumQuestion, Long> {
}
