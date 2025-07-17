package kr.co.wellbe.front.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/user/index")
    public String index() {
        return "index";
    }
}
