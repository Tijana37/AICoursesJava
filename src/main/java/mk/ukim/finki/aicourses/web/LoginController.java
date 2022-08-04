package mk.ukim.finki.aicourses.web;

import mk.ukim.finki.aicourses.model.User;
import mk.ukim.finki.aicourses.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/signin")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getLogin(Model model){
        return "signin";
    }

    @PostMapping
    public String postLogin(@RequestParam String email,
                            @RequestParam String password,
                            Model model,
                            HttpSession session){
        User user = null;
        try {
            user = this.userService.login(email, password);
            System.out.println(user);
            session.setAttribute("user", user);

            return "redirect:/courses";
        } catch (Exception exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "signin";
        }
    }

}
