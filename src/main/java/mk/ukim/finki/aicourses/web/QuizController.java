package mk.ukim.finki.aicourses.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quizes")
public class QuizController {
    @GetMapping
    public String getQuizes(Model model){
        return "quizes";
    }

    @GetMapping("/quiz_AI_intro")
    public String getQuizAI(Model model){
        return "quiz_AI_intro";
    }
}
