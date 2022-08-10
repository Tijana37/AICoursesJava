package mk.ukim.finki.aicourses.config;

import mk.ukim.finki.aicourses.model.User;
import mk.ukim.finki.aicourses.model.enums.Role;
import mk.ukim.finki.aicourses.service.CourseService;
import mk.ukim.finki.aicourses.service.QuizService;
import mk.ukim.finki.aicourses.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    public static final String ADMIN = "admin";

    private final UserService userService;

    private final CourseService courseService;

    private final QuizService quizService;

    public DataInitializer(UserService userService, CourseService courseService, QuizService quizService) {
        this.userService = userService;
        this.courseService = courseService;
        this.quizService = quizService;
    }

    @PostConstruct
    public void initData() {
        //User admin = this.userService.create("Admin", "Admin", "admin", "admin","","", Role.ADMIN);

//        //Course 1
//        this.courseService.create("Вовед во вештачка интелигенција", 5L, "Ана Анева", "BEGINNER", 0L );
//
//        //Course 2
//        this.courseService.create("Mашинско учење во продукција", 7L, "Марко Марков", "MIDDLE", 0L );
//

//        //Quiz 1
//        this.quizService.create("Вовед во вештачка интелигенција", 40L, "BEGINNER", 50L );
//
//        //Quiz 2
//        this.quizService.create("Mашинско учење во продукција", 70L, "MIDDLE", 70L );

    }
}
