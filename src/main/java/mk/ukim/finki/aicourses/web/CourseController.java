package mk.ukim.finki.aicourses.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @GetMapping
    public String getCourses(Model model) {
        return "courses";
    }

    @GetMapping("/course_AI_intro")
    public String getCourseAIIntro(Model model) {
        return "course_AI_intro";

    }

    @GetMapping("/ML_production")
    public String getMLProduction(Model model) {
        return "course_ML_Production";

    }
}
