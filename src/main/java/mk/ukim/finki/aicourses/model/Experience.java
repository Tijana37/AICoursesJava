package mk.ukim.finki.aicourses.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    @ManyToOne
    private User userSharesExp;

    public Experience() {
    }

    public Experience(String title, String description, User userSharesExp) {
        this.title = title;
        this.description = description;
        this.userSharesExp = userSharesExp;
    }
}
