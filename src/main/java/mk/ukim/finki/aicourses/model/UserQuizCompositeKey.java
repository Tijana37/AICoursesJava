package mk.ukim.finki.aicourses.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class UserQuizCompositeKey implements Serializable {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "quiz_id")
    private Long quizId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserQuizCompositeKey that = (UserQuizCompositeKey) o;
        return userId.equals(that.userId) && quizId.equals(that.quizId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, quizId);
    }
}
