package mk.ukim.finki.aicourses.service;

import mk.ukim.finki.aicourses.model.User;
import mk.ukim.finki.aicourses.model.enums.Role;

public interface UserService  {

    User create(String username, String password, String email, String proffesion, Role role);

}
