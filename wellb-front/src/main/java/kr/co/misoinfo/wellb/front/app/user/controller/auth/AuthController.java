package kr.co.misoinfo.wellb.front.app.user.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
    @GetMapping("/user/auth/login")
    public String login() {
        return "user/auth/login";
    }
}
