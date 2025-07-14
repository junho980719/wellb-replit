
package kr.co.misoinfo.wellb.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "Login Page");
        return "user/login";
    }
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "User Management Page");
        return "user/index";
    }
}
