package kr.co.misoinfo.wellb.front.app.user.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/")
    public String testIndex() {
        return "index";
    }
}
