package mk.ukim.finki.aicourses.service;

import mk.ukim.finki.aicourses.model.Experience;
import mk.ukim.finki.aicourses.model.ForumQuestion;
import mk.ukim.finki.aicourses.model.User;

import java.util.List;
import java.util.Optional;

public interface ForumQuestionService {
    List<ForumQuestion> listAllForumQuestions();

    Optional<ForumQuestion> findById(Long id);

    ForumQuestion create(String title, String category, String description, User userSharesExp);

    ForumQuestion update(Long id, String title, String category, String description, User userAsksQ);

    void delete(Long id);
}
