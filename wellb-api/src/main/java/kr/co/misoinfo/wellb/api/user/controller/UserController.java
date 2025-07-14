
package kr.co.misoinfo.wellb.api.user.controller;

import kr.co.misoinfo.wellb.api.user.dto.UserSignupRequest;
import kr.co.misoinfo.wellb.api.user.entity.User;
import kr.co.misoinfo.wellb.api.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@Valid @RequestBody UserSignupRequest request) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            User user = userService.signup(request);
            response.put("success", true);
            response.put("message", "회원가입이 완료되었습니다.");
            response.put("userId", user.getId());
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @GetMapping("/check-email")
    public ResponseEntity<Map<String, Object>> checkEmail(@RequestParam String email) {
        Map<String, Object> response = new HashMap<>();
        
        boolean exists = userService.checkEmailExists(email);
        response.put("exists", exists);
        response.put("message", exists ? "이미 사용중인 이메일입니다." : "사용 가능한 이메일입니다.");
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/check-phone")
    public ResponseEntity<Map<String, Object>> checkPhone(@RequestParam String phone) {
        Map<String, Object> response = new HashMap<>();
        
        boolean exists = userService.checkPhoneExists(phone);
        response.put("exists", exists);
        response.put("message", exists ? "이미 사용중인 연락처입니다." : "사용 가능한 연락처입니다.");
        
        return ResponseEntity.ok(response);
    }
}
