package mk.ukim.finki.aicourses.web;

import mk.ukim.finki.aicourses.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/quizes")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public String getQuizes(Model model){
        return "quizes";
    }

    @GetMapping("/quiz_AI_intro")
    public String getQuizAI(Model model){
        List<Integer> range = List.of(0,1,2);
        model.addAttribute("range", range);
        model.addAttribute("questions", quizService.findByName("Вовед во вештачка интелигенција").get().getQuestions());
        return "quiz_AI_intro2";
    }

    @PostMapping("/certificate")
    public String getCertificate(@RequestParam("checkboxName")String[] checkboxValue,
                                 Model model){
       for( String s : checkboxValue){
           System.out.println(s);
       }
        return "/certificate";
    }
}
