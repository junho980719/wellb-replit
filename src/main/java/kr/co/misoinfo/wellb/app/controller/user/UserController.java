package kr.co.misoinfo.wellb.app.controller.user;

import kr.co.misoinfo.wellb.app.domain.user.User;
import kr.co.misoinfo.wellb.app.service.user.UserService;
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
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// ID로 사용자 조회
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	// 이메일로 사용자 조회
	@GetMapping("/email/{email}")
	public User getUserByEmail(@PathVariable String email) {
		return userService.getUserByEmail(email);
	}

	// 사용자 생성
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	// 사용자 수정
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
		return userService.updateUser(id, userDetails);
	}

	// 사용자 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello from Wellb API!";
	}
}