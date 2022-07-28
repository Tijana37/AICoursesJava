package mk.ukim.finki.aicourses.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.aicourses.model.enums.KnowledgeLevel;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private KnowledgeLevel level;

    private Long longitude;

    private String teacher;

    @ManyToOne
    private Quiz suggestedQuiz; //when finished the Course

    public Course(String name, KnowledgeLevel level, Long longitude, String teacher, Quiz suggestedQuiz) {
        this.name = name;
        this.level = level;
        this.longitude = longitude;
        this.teacher = teacher;
        this.suggestedQuiz = suggestedQuiz;
    }
}
