
package kr.co.misoinfo.wellb.front.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request) {
        model.addAttribute("title", "Login Page");
        
        // HTMX 요청인지 확인
        if (request.getHeader("HX-Request") != null) {
            return "user/login-content";
        }
        
        return "user/login";
    }
    
    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("message", "User Management Page");
        model.addAttribute("title", "User Management");
        
        // HTMX 요청인지 확인
        if (request.getHeader("HX-Request") != null) {
            return "user/index-content";
        }
        
        return "user/index";
    }
}
