package mk.ukim.finki.aicourses.web;

import mk.ukim.finki.aicourses.model.User;
import mk.ukim.finki.aicourses.service.ExperienceService;
import mk.ukim.finki.aicourses.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    private final UserService userService;
    private final ExperienceService experienceService;

    public MainController(UserService userService, ExperienceService experienceService) {
        this.userService = userService;
        this.experienceService = experienceService;
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
        model.addAttribute("experiences",experienceService.listAllExperiences());
        return "experiences2";
    }


    @GetMapping("/experiences/experience_form")
    public String getExperienceForm(Model model){
        return "experience_form";
    }

    @PostMapping("/experiences")
    public String takeExperienceForm(@RequestParam String title,
                                     @RequestParam String description,
                                     HttpSession session,Model model){
        User currentUser = (User) session.getAttribute("user");
        experienceService.create(title,description, currentUser);
        return "redirect:/experiences";
    }
    @GetMapping("/profile")
    public String getProfile(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        try {
          return "profile";
        } catch (Exception exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "register";
        }
    }

}
