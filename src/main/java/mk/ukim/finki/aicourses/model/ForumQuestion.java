package mk.ukim.finki.aicourses.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ForumQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    //TODO: implement category enum to search via category
    private String category;

    @ManyToOne
    private User userAnswers;
}
