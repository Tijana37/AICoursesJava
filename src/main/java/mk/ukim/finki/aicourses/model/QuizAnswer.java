package mk.ukim.finki.aicourses.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class QuizAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String option1;
    private String option2;
    private String option3;

    private boolean isTrueOption1;
    private boolean isTrueOption2;
    private boolean isTrueOption3;

    public List<String> getAllOptions(){
        return List.of(option1,option2,option3);
    }
}
