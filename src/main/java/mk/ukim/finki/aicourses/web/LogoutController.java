package mk.ukim.finki.aicourses.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/logout")
public class LogoutController {
    @GetMapping
    String logout(HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/courses";
    }
}
