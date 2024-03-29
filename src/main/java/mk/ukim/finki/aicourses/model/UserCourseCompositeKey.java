package mk.ukim.finki.aicourses.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class UserCourseCompositeKey implements Serializable {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "course_id")
    private Long courseId;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCourseCompositeKey that = (UserCourseCompositeKey) o;
        return userId.equals(that.userId) && courseId.equals(that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, courseId);
    }
}
