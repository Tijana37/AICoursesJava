package mk.ukim.finki.aicourses.config;


import antlr.collections.impl.IntRange;
import mk.ukim.finki.aicourses.model.User;
import mk.ukim.finki.aicourses.model.enums.Role;
import mk.ukim.finki.aicourses.service.CourseService;
import mk.ukim.finki.aicourses.service.QuizService;
import mk.ukim.finki.aicourses.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
//        this.courseService.create("Вовед во вештачка интелигенција", 5L, "Ана Анева",
//                "BEGINNER", 0L );
//
//        this.courseService.addCoursePart("Вовед во вештачка интелигенција",
//                "Што е Вештачка интелигенција?",
//                "Вештачка интелигенција (ВИ) е интелигенција претставена од машини и софтвер и е гранка од компјутерската наука која развива машини и софтвер со интелигенција. Најголемите истражувања како и објавените трудови за ВИ истата ја дефинираат како проучување и дизајн на интелигентен агент, каде под интелигентен агент се подразбира систем способен за перцепирање на околината и преземање на активности кои му ги максимизираат шансите за успех. John McCarthy, човекот кој во 1956 ја измисли синтагмата, ја дефинираше како наука и инженерство за создавање на интелигентни машини.\n");

//        //Course 2
//        this.courseService.create("Mашинско учење во продукција", 7L, "Марко Марков",
//                "MIDDLE", 0L );
//
//        this.courseService.addCoursePart("Mашинско учење во продукција",
//                "Што е Вештачка интелигенцијаrr?",
//                "Вештачка интелигенцијаss (ВИ) е интелигенција претставена од машини и софтвер и е гранка од компјутерската наука која развива машини и софтвер со интелигенција. Најголемите истражувања како и објавените трудови за ВИ истата ја дефинираат како проучување и дизајн на интелигентен агент, каде под интелигентен агент се подразбира систем способен за перцепирање на околината и преземање на активности кои му ги максимизираат шансите за успех. John McCarthy, човекот кој во 1956 ја измисли синтагмата, ја дефинираше како наука и инженерство за создавање на интелигентни машини.\n");

//        //Quiz 1
//        this.quizService.create("Вовед во вештачка интелигенција", 40L, "BEGINNER",
//                50L );
//
//        //Quiz 2
//        this.quizService.create("Mашинско учење во продукција", 70L, "MIDDLE", 70L );

    }
}
