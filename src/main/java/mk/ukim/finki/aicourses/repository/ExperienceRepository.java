package mk.ukim.finki.aicourses.repository;

import mk.ukim.finki.aicourses.model.Course;
import mk.ukim.finki.aicourses.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {}
