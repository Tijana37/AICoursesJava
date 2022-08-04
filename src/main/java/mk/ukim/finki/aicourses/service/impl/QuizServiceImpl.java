package mk.ukim.finki.aicourses.service.impl;

import mk.ukim.finki.aicourses.model.Course;
import mk.ukim.finki.aicourses.model.Quiz;
import mk.ukim.finki.aicourses.model.enums.KnowledgeLevel;
import mk.ukim.finki.aicourses.model.exceptions.QuizIdException;
import mk.ukim.finki.aicourses.repository.QuizRepository;
import mk.ukim.finki.aicourses.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public List<Quiz> listAllQuizes() {
        return quizRepository.findAll();
    }

    @Override
    public Optional<Quiz> findById(Long id) {
        return quizRepository.findById(id);
    }

    @Override
    public Quiz create(String name, Long longitude, String level, Long minPoints) {
        return quizRepository.save(new Quiz(name, KnowledgeLevel.valueOf(level), longitude, minPoints) );
    }


    @Override
    public Quiz update(Long id, String name, Long longitude, String level, Long minPoints) {
        return null;
    }

    @Override
    public void delete(Long id) {
        quizRepository.deleteById(id);
    }

    @Override
    public Optional<Quiz> findByName(String name) {
        return quizRepository.findByName(name);

    }

    @Override
    public boolean isPassed(String[] checkboxValues) {
        return false;
    }
}
