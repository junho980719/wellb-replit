
package kr.co.misoinfo.wellb.front.controller.home;

import kr.co.misoinfo.wellb.front.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController extends BaseController {
    
    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("message", "Welcome to Wellb Front!");
        model.addAttribute("title", "Home");
        
        return getTemplateName(request, "home/index", "home/index-content");
    }
}
