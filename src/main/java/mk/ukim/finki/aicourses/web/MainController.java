package mk.ukim.finki.aicourses.web;

import mk.ukim.finki.aicourses.model.User;
import mk.ukim.finki.aicourses.service.ExperienceService;
import mk.ukim.finki.aicourses.service.ForumQuestionService;
import mk.ukim.finki.aicourses.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    private final UserService userService;
    private final ExperienceService experienceService;

    private final ForumQuestionService forumQuestionService;

    public MainController(UserService userService, ExperienceService experienceService, ForumQuestionService forumQuestionService) {
        this.userService = userService;
        this.experienceService = experienceService;
        this.forumQuestionService = forumQuestionService;
    }

    @GetMapping({"/", "/index"})
    public String introPage(Model model) {
        return "index";
    }

    @GetMapping({"/documentation"})
    public String documentation(Model model) {
        return "documentation";
    }

    @PostMapping({"/subscribe"})
    public String subscribe(@RequestParam String email, Model model) {
        if (email != null && email != "") {
            model.addAttribute("subscribe", true);
        } else {
            model.addAttribute("subscribe", false);
        }
        return "index";
    }

    @PostMapping({"/suggestion"})
    public String suggestion(@RequestParam String suggestion, Model model) {
        if (suggestion != null && suggestion != "") {
            model.addAttribute("suggestion", true);
        } else {
            model.addAttribute("suggestion", false);
        }
        return "courses";
    }

    @GetMapping("/forum")
    public String getForum(@RequestParam(required = false) String published, Model model) {
        if (published != null && published.equals("True")) {
            model.addAttribute("published", true);
        }
        model.addAttribute("questions", forumQuestionService.listAllForumQuestions());

        return "forum";
    }

    @GetMapping("/forum/forumQuestion")
    public String getForumQuestion(Model model) {
        return "forumQuestion";
    }

    @PostMapping("/forum/forumQuestion")
    public String getForumPost(@RequestParam String title,
                               @RequestParam String category,
                               @RequestParam String description,
                               HttpSession session, Model model) {
        User currentUser = (User) session.getAttribute("user");
        try {
            forumQuestionService.create(title, category, description, currentUser);
        } catch (Exception e) {
            model.addAttribute("error", true);
            model.addAttribute("errorMessage", e.getMessage());
            return "forumQuestion";
        }
        return "redirect:/forum?published=True";
    }

    @GetMapping("/experiences")
    public String getExperiences(@RequestParam(required = false) String published, Model model) {
        if (published != null && published.equals("True")) {
            model.addAttribute("published", true);
        }
        model.addAttribute("experiences", experienceService.listAllExperiences());
        return "experiences2";
    }

    @GetMapping("/experiences/experience_form")
    public String getExperienceForm(Model model) {
        return "experience_form";
    }

    @PostMapping("/experiences")
    public String takeExperienceForm(@RequestParam String title,
                                     @RequestParam String description,
                                     HttpSession session, Model model) {
        User currentUser = (User) session.getAttribute("user");
        try {
            experienceService.create(title, description, currentUser);
        } catch (Exception e) {
            model.addAttribute("error", true);
            model.addAttribute("errorMessage", e.getMessage());
            return "experience_form";
        }
        return "redirect:/experiences?published=True";
    }

    @GetMapping("/profile")
    public String getProfile(HttpSession session, Model model) {
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
