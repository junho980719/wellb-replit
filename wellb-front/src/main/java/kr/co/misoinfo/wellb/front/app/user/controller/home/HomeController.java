package kr.co.misoinfo.wellb.front.app.user.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class HomeController {
    @GetMapping("/user/main")
    public String main(@RequestHeader(value = "HX-Request", required = false) String hxRequest) {
        return "user/main";
    }
}
