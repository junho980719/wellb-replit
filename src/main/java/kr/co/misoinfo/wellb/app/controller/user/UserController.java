package kr.co.misoinfo.wellb.app.controller.user;

import kr.co.misoinfo.wellb.app.domain.user.User;
import kr.co.misoinfo.wellb.app.service.user.UserService;
import kr.co.misoinfo.wellb.common.response.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// 모든 사용자 조회
	@GetMapping
	public ApiResult<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return ApiResult.ok(users);
	}

	// ID로 사용자 조회
	@GetMapping("/{id}")
	public ApiResult<User> getUserById(@PathVariable Long id) {
		User user = userService.getUserById(id);
		return ApiResult.ok(user);
	}

	// 이메일로 사용자 조회
	@GetMapping("/email/{email}")
	public ApiResult<User> getUserByEmail(@PathVariable String email) {
		User user = userService.getUserByEmail(email);
		return ApiResult.ok(user);
	}

	// 사용자 생성
	@PostMapping
	public ApiResult<User> createUser(@RequestBody User user) {
		User createdUser = userService.createUser(user);
		return ApiResult.ok(createdUser, "사용자가 성공적으로 생성되었습니다");
	}

	// 사용자 수정
	@PutMapping("/{id}")
	public ApiResult<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
		User updatedUser = userService.updateUser(id, userDetails);
		return ApiResult.ok(updatedUser, "사용자 정보가 성공적으로 수정되었습니다");
	}

	// 사용자 삭제
	@DeleteMapping("/{id}")
	public ApiResult<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ApiResult.ok(null, "사용자가 성공적으로 삭제되었습니다");
	}

	@GetMapping("/hello")
	public ApiResult<String> hello() {
		return ApiResult.ok("Hello from Wellb API!");
	}
}