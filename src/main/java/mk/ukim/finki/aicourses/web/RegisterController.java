package mk.ukim.finki.aicourses.web;

import mk.ukim.finki.aicourses.model.User;
import mk.ukim.finki.aicourses.model.enums.Role;
import mk.ukim.finki.aicourses.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegister(Model model) {
        return "register";
    }

    @PostMapping
    public String postRegister(@RequestParam String name,
                               @RequestParam String surname,
                               @RequestParam String username,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String repeatedpassword,
                               @RequestParam String profession,
                               @RequestParam MultipartFile profilephoto, //do not put ("file"), wont work
                               Model model
    ) {
        //TODO: implement if verificationFile!=null -> Role.VERIFIED
        try {
            User user = this.userService.create(name, surname, username, password, email, profession, Role.BASIC, profilephoto.getBytes());
            return "redirect:/signin";
        } catch (RuntimeException e) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", e.getMessage());
            return "redirect:/register?error=" + e.getMessage();
        } catch (IOException e) { //because of the image conversion to byte array
            throw new RuntimeException(e);
        }
    }
}
