package mk.ukim.finki.aicourses.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserCourse {

    @EmbeddedId
    private UserCourseCompositeKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    Course course;


    //TODO: implement lectures in course to make this valid
    private Long numLecture;

}
