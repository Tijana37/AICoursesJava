package mk.ukim.finki.aicourses.service.impl;

import mk.ukim.finki.aicourses.model.CoursePart;
import mk.ukim.finki.aicourses.model.exceptions.CourseIdException;
import mk.ukim.finki.aicourses.repository.CoursePartRepository;
import mk.ukim.finki.aicourses.service.CoursePartService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoursePartServiceImpl implements CoursePartService {
    private final CoursePartRepository coursePartRepository;

    public CoursePartServiceImpl(CoursePartRepository coursePartRepository) {
        this.coursePartRepository = coursePartRepository;
    }
    @Override
    public CoursePart create(String title, String text) {
        return coursePartRepository.save(new CoursePart(title, text));
    }

    @Override
    public CoursePart update(Long id, String title, String text) {
        Optional<CoursePart> coursePart = coursePartRepository.findById(id);
        if (coursePart.isPresent()) {
            coursePart.get().setTitle(title);
            coursePart.get().setText(text);
            return coursePartRepository.save(coursePart.get());
        }
        else throw new CourseIdException();
    }

    @Override
    public CoursePart delete(Long id) {
        Optional<CoursePart> coursePart = coursePartRepository.findById(id);
        if (coursePart.isPresent()) {
            coursePartRepository.deleteById(id);
            return coursePart.get();
        } else throw new CourseIdException();
    }
}
