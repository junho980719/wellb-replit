package kr.co.misoinfo.wellb.front.app.user.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("/user/main")
    public String main() {
        return "user/main";
    }
}
