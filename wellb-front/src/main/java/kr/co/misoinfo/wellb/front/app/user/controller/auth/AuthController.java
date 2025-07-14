package kr.co.misoinfo.wellb.front.app.user.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/user/auth/login")
    public String login() {
        return "user/auth/login";
    }

    @GetMapping("/user/auth/signup")
    public String signIn() {
        return "user/auth/signup";
    }
}
