package mk.ukim.finki.aicourses.service.impl;

import mk.ukim.finki.aicourses.model.Course;
import mk.ukim.finki.aicourses.model.Quiz;
import mk.ukim.finki.aicourses.model.enums.KnowledgeLevel;
import mk.ukim.finki.aicourses.model.exceptions.CourseIdException;
import mk.ukim.finki.aicourses.model.exceptions.QuizIdException;
import mk.ukim.finki.aicourses.repository.CourseRepository;
import mk.ukim.finki.aicourses.repository.QuizRepository;
import mk.ukim.finki.aicourses.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final QuizRepository quizRepository;

    public CourseServiceImpl(CourseRepository courseRepository, QuizRepository quizRepository) {
        this.courseRepository = courseRepository;
        this.quizRepository = quizRepository;
    }

    @Override
    public List<Course> listAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course create(String name, Long longitude, String teacher, String level, Long suggestedQuiz) {
        Optional<Quiz> suggestedQuizObj = quizRepository.findById(suggestedQuiz);
        return suggestedQuizObj.map(quiz -> courseRepository.save(new Course(name, KnowledgeLevel.valueOf(level), longitude, teacher, quiz)))
                .orElseGet(() -> courseRepository.save(new Course(name, KnowledgeLevel.valueOf(level), longitude, teacher, null)));

    }

    //TODO:  implement update method
    @Override
    public Course update(Long id, String name, Long longitude, String teacher, String level) {
        return null;
    }

    @Override
    public Course delete(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()) {
            courseRepository.deleteById(id);
            return course.get();
        }
        else throw new CourseIdException();
    }
}
