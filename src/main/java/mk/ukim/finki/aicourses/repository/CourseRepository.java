package mk.ukim.finki.aicourses.repository;

import mk.ukim.finki.aicourses.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
