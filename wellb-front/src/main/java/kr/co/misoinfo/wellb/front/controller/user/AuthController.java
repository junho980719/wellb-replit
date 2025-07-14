package kr.co.misoinfo.wellb.front.controller.user;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.misoinfo.wellb.front.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/auth")
public class AuthController extends BaseController {

    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request) {
        model.addAttribute("title", "User Login");
        return "user/auth/login";
    }

    @GetMapping("/signup")
    public String signup(Model model, HttpServletRequest request) {
        model.addAttribute("title", "User Signup");
        return "user/auth/signup";
    }

    @GetMapping("/signup-step2")
    public String signupStep2(Model model, HttpServletRequest request) {
        model.addAttribute("title", "User Signup Step 2");
        return "user/auth/signup-step2";
    }
}
