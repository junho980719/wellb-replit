
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

}
