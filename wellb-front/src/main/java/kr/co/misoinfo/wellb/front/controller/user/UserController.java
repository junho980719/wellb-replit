
package kr.co.misoinfo.wellb.front.controller.user;

import kr.co.misoinfo.wellb.front.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("message", "User Management Page");
        model.addAttribute("title", "User Management");
        return getTemplateName(request, "user/index", "user/index-content");
    }

    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request) {
        model.addAttribute("title", "User Login");
        return getTemplateName(request, "user/login", "user/login-content");
    }

    @GetMapping("/signup")
    public String signup(Model model, HttpServletRequest request) {
        model.addAttribute("title", "User Signup");
        return getTemplateName(request, "user/signup", "user/signup-content");
    }

    @GetMapping("/signup-step2")
    public String signupStep2(Model model, HttpServletRequest request) {
        model.addAttribute("title", "User Signup Step 2");
        return getTemplateName(request, "user/signup-step2", "user/signup-step2-content");
    }
}
