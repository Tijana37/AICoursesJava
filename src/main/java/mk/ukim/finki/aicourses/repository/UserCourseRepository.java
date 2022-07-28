package mk.ukim.finki.aicourses.repository;

import mk.ukim.finki.aicourses.model.Course;
import mk.ukim.finki.aicourses.model.UserCourse;
import mk.ukim.finki.aicourses.model.UserCourseCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCourseRepository extends JpaRepository<UserCourse, UserCourseCompositeKey> {
}
