package mk.ukim.finki.aicourses.repository;
import mk.ukim.finki.aicourses.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
        User findByEmail(String email);
}
