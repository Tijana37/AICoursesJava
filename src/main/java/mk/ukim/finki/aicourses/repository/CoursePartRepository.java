package mk.ukim.finki.aicourses.repository;

import mk.ukim.finki.aicourses.model.CoursePart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursePartRepository extends JpaRepository<CoursePart, Long> {
}
