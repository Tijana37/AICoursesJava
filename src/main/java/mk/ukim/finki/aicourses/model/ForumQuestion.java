package mk.ukim.finki.aicourses.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ForumQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    //TODO: implement category enum to search via category
    private String category;

    @ManyToOne
    private User userAsks;

    public ForumQuestion(String title, String description, String category, User userAsks) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.userAsks = userAsks;
    }
}
