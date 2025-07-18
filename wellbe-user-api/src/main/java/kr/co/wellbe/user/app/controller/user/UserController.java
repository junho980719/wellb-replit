package kr.co.wellbe.user.app.controller.user;

import kr.co.misoinfo.core.common.response.ApiResult;
import kr.co.wellbe.user.app.dto.user.JwtResponse;
import kr.co.wellbe.user.app.dto.user.LoginRequest;
import kr.co.wellbe.user.app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/login")
    public ApiResult<JwtResponse> login(@RequestBody LoginRequest loginRequest) {
        String token = userService.login(loginRequest);
        return ApiResult.ok(new JwtResponse(token));
    }

}
