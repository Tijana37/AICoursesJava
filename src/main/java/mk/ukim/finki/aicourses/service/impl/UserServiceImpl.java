package mk.ukim.finki.aicourses.service.impl;

import mk.ukim.finki.aicourses.model.User;
import mk.ukim.finki.aicourses.model.enums.Role;
import mk.ukim.finki.aicourses.model.exceptions.UserExistsException;
import mk.ukim.finki.aicourses.model.exceptions.UserNotExistsException;
import mk.ukim.finki.aicourses.repository.UserRepository;
import mk.ukim.finki.aicourses.service.UserService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User create(String name, String surname, String username, String password, String email, String profession, Role role, byte[] profilePhoto) throws RuntimeException, IOException {
        if (userRepository.findByEmail(email) != null)
            throw new UserExistsException("User already exists!");

        Path newFile = Paths.get("src/main/resources/static/assets/userPhotos/" + username + ".png");
        Files.write(newFile, profilePhoto);

        return userRepository.save(new User(username, name, surname, password, email, profession, role, profilePhoto));

    }

    @Override
    public User login(String email, String password) {
        User u = userRepository.findByEmail(email);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        throw new UserNotExistsException();
    }
}
