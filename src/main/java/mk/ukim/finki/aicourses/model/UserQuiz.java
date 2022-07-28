package mk.ukim.finki.aicourses.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserQuiz {

    @EmbeddedId
    private UserQuizCompositeKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("quizId")
    @JoinColumn(name = "quiz_id")
    Quiz quiz;


    //TODO: implement lectures in course to make this valid
    private String certificate;

    private Long totalPoints;
}
