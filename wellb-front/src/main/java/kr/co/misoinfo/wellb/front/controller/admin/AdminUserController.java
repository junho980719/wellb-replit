
package kr.co.misoinfo.wellb.front.controller.admin;

import kr.co.misoinfo.wellb.front.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminUserController extends BaseController {

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("message", "Admin Dashboard");
        model.addAttribute("title", "Admin Dashboard");
        return getTemplateName(request, "admin/index", "admin/index-content");
    }

    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request) {
        model.addAttribute("title", "Admin Login");
        return getTemplateName(request, "admin/login", "admin/login-content");
    }
}
