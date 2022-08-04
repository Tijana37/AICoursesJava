package mk.ukim.finki.aicourses.web;

import mk.ukim.finki.aicourses.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping({"/", "/index"})
    public String introPage(Model model){
        return "index";
    }

    @PostMapping({"/subscribe"})
    public String subscribe(@RequestParam String email,Model model){
        if(email!=null && email!=""){
        model.addAttribute("subscribe", "jkk");
        }
        return "index";
    }
    @PostMapping({"/suggestion"})
    public String suggestion(@RequestParam String suggestion,Model model){
        if(suggestion!=null && suggestion!=""){
            model.addAttribute("suggestion", "jkk");
        }
        return "courses";
    }
    @GetMapping("/forum")
    public String getForum(Model model){
        return "forum";
    }

    @GetMapping("/experiences")
    public String getExperiences(Model model){
        return "experiences";
    }


}
