package mk.ukim.finki.aicourses.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String question;

    @OneToOne
    private QuizAnswer answers;


}
