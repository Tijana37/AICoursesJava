package mk.ukim.finki.aicourses.web;

import mk.ukim.finki.aicourses.model.enums.Role;
import mk.ukim.finki.aicourses.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegister(Model model){
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam String name,
                               @RequestParam String surname,
                               @RequestParam String username,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String repeatedpassword,
                               @RequestParam String profession,
                               Model model
                               //@RequestParam("image") MultipartFile verificationFile
    ) {

        //TODO: implement if verificationFile!=null -> Role.VERIFIED
        try {
            this.userService.create(name, surname, username, password, email, profession, Role.BASIC);
            return "redirect:/signin";
        }
        catch(RuntimeException e){
            model.addAttribute("hasError", true);
            model.addAttribute("error", "User Already Exists");
            return "redirect:/register?error=" + e.getMessage();
        }

    }

}
