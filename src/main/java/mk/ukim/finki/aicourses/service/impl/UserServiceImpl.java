package mk.ukim.finki.aicourses.service.impl;

import mk.ukim.finki.aicourses.model.User;
import mk.ukim.finki.aicourses.model.enums.Role;
import mk.ukim.finki.aicourses.model.exceptions.UserExistsException;
import mk.ukim.finki.aicourses.model.exceptions.UserNotExistsException;
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
    public User create(String name, String surname, String username, String password, String email, String profession, Role role) throws RuntimeException {
        if (userRepository.findByEmail(email)!=null)
            throw new UserExistsException();
        return userRepository.save(new User(username,name, surname, password, email, profession, role));

    }

    @Override
    public User login(String email, String password) {
        User u = userRepository.findByEmail(email);
        if(u != null &&  u.getPassword().equals(password)){
           return u;
        }
        throw new UserNotExistsException();
    }
}
