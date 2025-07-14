
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
        return "user/index";
    }

    @GetMapping("/auth/login")
    public String login(Model model, HttpServletRequest request) {
        model.addAttribute("title", "로그인");
        return "user/auth/login";
    }

    @GetMapping("/auth/signup")
    public String signup(Model model, HttpServletRequest request) {
        model.addAttribute("title", "회원가입");
        return "user/auth/signup";
    }

    @GetMapping("/auth/signup-step2")
    public String signupStep2(Model model, HttpServletRequest request) {
        model.addAttribute("title", "추가 정보");
        return "user/auth/signup-step2";
    }

}
