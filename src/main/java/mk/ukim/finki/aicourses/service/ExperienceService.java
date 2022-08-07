package mk.ukim.finki.aicourses.service;

import mk.ukim.finki.aicourses.model.Experience;
import mk.ukim.finki.aicourses.model.Quiz;
import mk.ukim.finki.aicourses.model.User;

import java.util.List;
import java.util.Optional;

public interface ExperienceService {
    List<Experience> listAllExperiences();

    Optional<Experience> findById(Long id);

    Experience create(String title, String description, User userSharesExp);

    Experience update(Long id, String title, String description, User userSharesExp);

    void delete(Long id);

}
