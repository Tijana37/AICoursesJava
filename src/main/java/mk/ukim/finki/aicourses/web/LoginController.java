package mk.ukim.finki.aicourses.web;

import mk.ukim.finki.aicourses.model.User;
import mk.ukim.finki.aicourses.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/signin")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getLogin(@RequestParam(required = false) String fromexperience,
                           @RequestParam(required = false) String fromforum,
                           Model model) {
        if (fromexperience != null && fromexperience.equals("True")) {
            model.addAttribute("sentfromexperience", true);
        } else if (fromforum != null && fromforum.equals("True")) {
            model.addAttribute("sentfromforum", true);
        }
        return "signin";
    }

    @PostMapping
    public String postLogin(@RequestParam String email,
                            @RequestParam String password,
                            @RequestParam(required = false) String fromexperience,
                            @RequestParam(required = false) String fromforum,
                            Model model,
                            HttpSession session) {
        User user = null;
        try {
            user = this.userService.login(email, password);
            session.setAttribute("user", user);

            if (fromexperience != null && fromexperience.equals("True")) {
                return "redirect:/experiences/experience_form";
            }
            if (fromforum != null && fromforum.equals("True")) {
                return "redirect:/forum/forumQuestion";
            }

            return "redirect:/profile";
        } catch (Exception exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "signin";
        }
    }

}
