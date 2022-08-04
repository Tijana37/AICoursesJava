package mk.ukim.finki.aicourses.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.aicourses.model.enums.KnowledgeLevel;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private KnowledgeLevel level;

    private Long longitude;

    private Long minPoints;

    @OneToMany
    private List<QuizQuestion> questions;


    public Quiz(String name, KnowledgeLevel level, Long longitude, Long minPoints) {
        this.name = name;
        this.level = level;
        this.longitude = longitude;
        this.minPoints = minPoints;
    }
}
