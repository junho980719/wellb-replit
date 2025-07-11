package kr.co.misoinfo.wellb.app.service.user;

import kr.co.misoinfo.wellb.app.domain.user.User;
import kr.co.misoinfo.wellb.app.repository.user.UserRepository;
import kr.co.misoinfo.wellb.common.exception.BusinessException;
import kr.co.misoinfo.wellb.common.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		if (id == null || id <= 0) {
			throw new BusinessException(ErrorCode.INVALID_USER_ID);
		}
		return userRepository.findById(id)
			.orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND, String.valueOf(id)));
	}

	public User getUserByEmail(String email) {
		if (!StringUtils.hasText(email)) {
			throw new BusinessException(ErrorCode.EMPTY_EMAIL);
		}
		return userRepository.findByEmail(email)
			.orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND, email));
	}

	public User createUser(User user) {
		// 입력값 검증
		if (user == null) {
			throw new BusinessException(ErrorCode.EMPTY_USER_INFO);
		}
		if (!StringUtils.hasText(user.getName())) {
			throw new BusinessException(ErrorCode.EMPTY_USER_NAME);
		}
		if (!StringUtils.hasText(user.getEmail())) {
			throw new BusinessException(ErrorCode.EMPTY_USER_EMAIL);
		}

		// 이메일 중복 체크
		if (userRepository.findByEmail(user.getEmail()).isPresent()) {
			throw new BusinessException(ErrorCode.DUPLICATE_EMAIL, user.getEmail());
		}

		return userRepository.save(user);
	}

	public User updateUser(Long id, User userDetails) {
		if (id == null || id <= 0) {
			throw new BusinessException(ErrorCode.INVALID_USER_ID);
		}
		if (userDetails == null) {
			throw new BusinessException(ErrorCode.EMPTY_UPDATE_INFO);
		}

		return userRepository.findById(id)
			.map(user -> {
				if (StringUtils.hasText(userDetails.getName())) {
					user.setName(userDetails.getName());
				}
				if (StringUtils.hasText(userDetails.getEmail()) && 
					!userDetails.getEmail().equals(user.getEmail())) {
					// 이메일 변경 시 중복 체크
					if (userRepository.findByEmail(userDetails.getEmail()).isPresent()) {
						throw new BusinessException(ErrorCode.DUPLICATE_EMAIL, userDetails.getEmail());
					}
					user.setEmail(userDetails.getEmail());
				}
				return userRepository.save(user);
			})
			.orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND, String.valueOf(id)));
	}

	public void deleteUser(Long id) {
		if (id == null || id <= 0) {
			throw new BusinessException(ErrorCode.INVALID_USER_ID);
		}

		if (!userRepository.existsById(id)) {
			throw new BusinessException(ErrorCode.USER_NOT_FOUND, String.valueOf(id));
		}
		
		userRepository.deleteById(id);
	}
}