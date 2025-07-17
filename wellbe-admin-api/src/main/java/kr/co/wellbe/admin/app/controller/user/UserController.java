
package kr.co.wellbe.admin.app.controller.user;

import kr.co.misoinfo.core.common.response.ApiResult;
import kr.co.wellbe.admin.app.service.user.UserService;
import kr.co.wellbe.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
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

	// USER_SEQ로 사용자 조회
	@GetMapping("/{userSeq}")
	public ApiResult<User> getUserBySeq(@PathVariable Integer userSeq) {
		User user = userService.getUserBySeq(userSeq);
		return ApiResult.ok(user);
	}

	// USER_ID로 사용자 조회
	@GetMapping("/userid/{userId}")
	public ApiResult<User> getUserByUserId(@PathVariable String userId) {
		User user = userService.getUserByUserId(userId);
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
	@PutMapping("/{userSeq}")
	public ApiResult<User> updateUser(@PathVariable Integer userSeq, @RequestBody User userDetails) {
		User updatedUser = userService.updateUser(userSeq, userDetails);
		return ApiResult.ok(updatedUser, "사용자 정보가 성공적으로 수정되었습니다");
	}

	// 사용자 삭제
	@DeleteMapping("/{userSeq}")
	public ApiResult<Void> deleteUser(@PathVariable Integer userSeq) {
		userService.deleteUser(userSeq);
		return ApiResult.ok(null, "사용자가 성공적으로 삭제되었습니다");
	}

	@GetMapping("/hello")
	public ApiResult<String> hello() {
		return ApiResult.ok("Hello from Wellb API!");
	}
}
