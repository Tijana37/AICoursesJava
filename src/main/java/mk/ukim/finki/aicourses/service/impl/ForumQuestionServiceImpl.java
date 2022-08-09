package mk.ukim.finki.aicourses.service.impl;

import mk.ukim.finki.aicourses.model.Experience;
import mk.ukim.finki.aicourses.model.ForumQuestion;
import mk.ukim.finki.aicourses.model.User;
import mk.ukim.finki.aicourses.model.exceptions.ExperienceFormEmptyException;
import mk.ukim.finki.aicourses.model.exceptions.ForumQuestionEmptyException;
import mk.ukim.finki.aicourses.model.exceptions.UserNotExistsException;
import mk.ukim.finki.aicourses.repository.ForumQuestionRepository;
import mk.ukim.finki.aicourses.service.ForumQuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForumQuestionServiceImpl implements ForumQuestionService {

    private final ForumQuestionRepository forumQuestionRepository;

    public ForumQuestionServiceImpl(ForumQuestionRepository forumQuestionRepository) {
        this.forumQuestionRepository = forumQuestionRepository;
    }

    @Override
    public List<ForumQuestion> listAllForumQuestions() {
        return forumQuestionRepository.findAll();
    }

    @Override
    public Optional<ForumQuestion> findById(Long id) {
        return forumQuestionRepository.findById(id);
    }

    @Override
    public ForumQuestion create(String title, String category, String description, User userAsksQ) {
        if(userAsksQ==null){
            throw new UserNotExistsException("Ве молиме најавете се пред да продолжите!");
        }
        if(title.isEmpty()&& category.isEmpty() && description.isEmpty()){
            throw new ForumQuestionEmptyException("Ве молиме пополнете ги трите полиња!");
        }
        if(title.isEmpty()){
            throw new ForumQuestionEmptyException("Ве молиме пополнете го полето за наслов!");
        }
        if(category.isEmpty()){
            throw new ForumQuestionEmptyException("Ве молиме пополнете го полето за категорија!");
        }
        if(description.isEmpty()){
            throw new ForumQuestionEmptyException("Ве молиме пополнете го полето за опис!");
        }
        return forumQuestionRepository.save(new ForumQuestion(title, description,category, userAsksQ));
    }


    @Override
    public ForumQuestion update(Long id, String title, String category, String description, User userSharesExp) {
        return null;
    }

    @Override
    public void delete(Long id) {
        forumQuestionRepository.delete(forumQuestionRepository.findById(id).get());

    }
}
