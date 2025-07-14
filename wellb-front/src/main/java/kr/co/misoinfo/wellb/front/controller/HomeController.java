
package kr.co.misoinfo.wellb.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("message", "Welcome to Wellb Front!");
        model.addAttribute("title", "Home");
        
        // HTMX 요청인지 확인
        if (request.getHeader("HX-Request") != null) {
            return "home/index-content";
        }
        
        return "home/index";
    }
}
