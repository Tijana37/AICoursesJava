package mk.ukim.finki.aicourses.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class CoursePart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String text;

    public CoursePart(String title, String text) {
        this.title = title;
        this.text = text;
    }

}
