package mk.ukim.finki.aicourses.service.impl;

import mk.ukim.finki.aicourses.model.User;
import mk.ukim.finki.aicourses.model.enums.Role;
import mk.ukim.finki.aicourses.repository.UserRepository;
import mk.ukim.finki.aicourses.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(String username, String password, String email, String profession, Role role) {
        return userRepository.save(new User(username, password, email, profession, role));
    }
}
