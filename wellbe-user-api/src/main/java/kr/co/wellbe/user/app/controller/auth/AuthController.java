package kr.co.wellbe.user.app.controller.auth;

import kr.co.misoinfo.core.common.response.ApiResult;
import kr.co.wellbe.user.app.dto.user.JwtResponse;
import kr.co.wellbe.user.app.dto.user.LoginRequest;
import kr.co.wellbe.user.app.dto.user.SignUpRequest;
import kr.co.wellbe.user.app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ApiResult<JwtResponse> login(@RequestBody LoginRequest request) {
        String token = userService.login(request);
        return ApiResult.ok(new JwtResponse(token));
    }

    @PostMapping("/sign-up")
    public ApiResult<Void> signUp(@RequestBody SignUpRequest request) {
        userService.signUp(request);
        return ApiResult.ok();
    }
}
