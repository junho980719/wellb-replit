package kr.co.misoinfo.wellb.front.app.user.controller.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/mypage")
public class MypageController {

    @GetMapping("/index")
    public String index() {
        return "user/mypage/index";
    }
}
