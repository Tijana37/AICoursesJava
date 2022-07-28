package mk.ukim.finki.aicourses.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CourseController {
    //private final CourseController courseController;

//
//    public CourseController(CourseController courseController) {
//        this.courseController = courseController;
//    }

    @GetMapping("/")
    public String introPage(Model model){

        return "index";
    }


    @GetMapping("/courses")
    public String getCourses(Model model){
        return "courses";

    }
}
