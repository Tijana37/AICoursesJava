package mk.ukim.finki.aicourses.service;

import mk.ukim.finki.aicourses.model.Course;
import mk.ukim.finki.aicourses.model.CoursePart;

public interface CoursePartService {

    CoursePart create(String title, String text);

    CoursePart update(Long id, String title, String text);

    CoursePart delete(Long id);
}
