package mk.ukim.finki.aicourses.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String question;

    @OneToOne
    private QuizAnswer answers;

    public QuizQuestion(String question, QuizAnswer answers) {
        this.question = question;
        this.answers = answers;
    }
}
