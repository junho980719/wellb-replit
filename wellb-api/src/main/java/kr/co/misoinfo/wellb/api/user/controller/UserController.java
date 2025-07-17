
package kr.co.misoinfo.wellb.api.user.controller;

import kr.co.misoinfo.wellb.api.user.dto.UserSignupRequest;
import kr.co.misoinfo.wellb.app.domain.user.User;
import kr.co.misoinfo.wellb.api.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import kr.co.misoinfo.wellb.common.response.ApiResult;
import kr.co.misoinfo.wellb.common.exception.BusinessException;
import kr.co.misoinfo.wellb.common.exception.ErrorCode;
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
    public ApiResult<Map<String, Object>> signup(@Valid @RequestBody UserSignupRequest request) {
        try {
            User user = userService.signup(request);
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("userId", user.getUserId());
            return ApiResult.ok(responseData, "회원가입이 완료되었습니다.");
        } catch (BusinessException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("회원가입 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
    
    @GetMapping("/check-email")
    public ApiResult<Map<String, Object>> checkEmail(@RequestParam String email) {
        boolean exists = userService.checkEmailExists(email);
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("exists", exists);
        return ApiResult.ok(responseData, exists ? "이미 사용중인 이메일입니다." : "사용 가능한 이메일입니다.");
    }
    
    @GetMapping("/check-phone")
    public ApiResult<Map<String, Object>> checkPhone(@RequestParam String phone) {
        boolean exists = userService.checkPhoneExists(phone);
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("exists", exists);
        return ApiResult.ok(responseData, exists ? "이미 사용중인 연락처입니다." : "사용 가능한 연락처입니다.");
    }
}
