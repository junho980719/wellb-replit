
package kr.co.misoinfo.wellb.front.controller.test;

import kr.co.misoinfo.wellb.front.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
public class TestController extends BaseController {
    
    @GetMapping("/ui")
    public String uiTest(Model model, HttpServletRequest request) {
        model.addAttribute("title", "UI Components Test");
        
        return getTemplateName(request, "test/ui-test", "test/ui-test-content");
    }
}
