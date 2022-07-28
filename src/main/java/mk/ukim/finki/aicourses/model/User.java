package mk.ukim.finki.aicourses.model;

import lombok.Data;
import mk.ukim.finki.aicourses.model.enums.Role;

import javax.persistence.*;

@Entity
@Table(name = "appUsers")
@Data
public class User {

    public User() {
    }

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Id
    private String username;

    private String password;

    private String email;

    private String proffesion;

    //TODO: implement verification document
    private String verificationPicture;

    @Enumerated(value = EnumType.STRING)
    private Role role;


    public User(String username, String password, String email, String profession, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.proffesion = profession;
        this.role = role;
    }
}