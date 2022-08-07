package mk.ukim.finki.aicourses.service;

import mk.ukim.finki.aicourses.model.User;
import mk.ukim.finki.aicourses.model.enums.Role;

import java.io.IOException;

public interface UserService  {

    User create(String name, String surname, String username, String password, String email, String proffesion, Role role, byte[] profilePhoto) throws IOException;

    User login(String email, String password);
}
