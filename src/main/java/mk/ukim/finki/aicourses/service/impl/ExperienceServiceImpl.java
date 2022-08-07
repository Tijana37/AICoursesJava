package mk.ukim.finki.aicourses.service.impl;

import mk.ukim.finki.aicourses.model.Experience;
import mk.ukim.finki.aicourses.model.User;
import mk.ukim.finki.aicourses.repository.ExperienceRepository;
import mk.ukim.finki.aicourses.service.ExperienceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceServiceImpl implements ExperienceService {
    private final ExperienceRepository experienceRepository;

    public ExperienceServiceImpl(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    public List<Experience> listAllExperiences() {
        return experienceRepository.findAll();
    }

    @Override
    public Optional<Experience> findById(Long id) {
        return experienceRepository.findById(id);
    }

    @Override
    public Experience create(String title, String description, User userSharesExp) {
        return experienceRepository.save(new Experience(title, description, userSharesExp));
    }

    @Override
    public Experience update(Long id, String title, String description, User userSharesExp) {
        return null;
    }

    @Override
    public void delete(Long id) {
        experienceRepository.delete(experienceRepository.findById(id).get());
    }
}
