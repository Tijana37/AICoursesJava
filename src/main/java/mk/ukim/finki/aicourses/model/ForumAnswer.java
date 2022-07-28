package mk.ukim.finki.aicourses.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ForumAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    @ManyToOne
    private ForumQuestion answersTo;

    @ManyToOne
    private User userAsks;
}
