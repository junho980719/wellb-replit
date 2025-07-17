package kr.co.wellbe.admin.app.service.user;

import kr.co.misoinfo.core.common.exception.BusinessException;
import kr.co.misoinfo.core.common.exception.ErrorCode;
import kr.co.wellbe.admin.app.domain.user.User;
import kr.co.wellbe.admin.app.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserBySeq(Integer userSeq) {
		return userRepository.findById(userSeq)
			.orElseThrow(() -> new BusinessException(ErrorCode.RESOURCE_NOT_FOUND, "User not found with userSeq: " + userSeq));
	}

	public User getUserByUserId(String userId) {
		return userRepository.findByUserId(userId)
			.orElseThrow(() -> new BusinessException(ErrorCode.RESOURCE_NOT_FOUND, "User not found with userId: " + userId));
	}

	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email)
			.orElseThrow(() -> new BusinessException(ErrorCode.RESOURCE_NOT_FOUND, "User not found with email: " + email));
	}

	public User createUser(User user) {
		// 중복 체크
		if (user.getUserId() != null && userRepository.existsByUserId(user.getUserId())) {
			throw new IllegalArgumentException("User ID already exists: " + user.getUserId());
		}
		if (user.getEmail() != null && userRepository.existsByEmail(user.getEmail())) {
			throw new IllegalArgumentException("Email already exists: " + user.getEmail());
		}

		// 기본값 설정
		user.setInputDt(LocalDateTime.now());
		user.setUserDelGu("N"); // 기본적으로 삭제되지 않음

		return userRepository.save(user);
	}

	public User updateUser(Integer userSeq, User userDetails) {
		User user = getUserBySeq(userSeq);

		// 필드 업데이트
		if (userDetails.getUserId() != null) {
			user.setUserId(userDetails.getUserId());
		}
		if (userDetails.getUserNm() != null) {
			user.setUserNm(userDetails.getUserNm());
		}
		if (userDetails.getEmail() != null) {
			user.setEmail(userDetails.getEmail());
		}
		if (userDetails.getHpNo() != null) {
			user.setHpNo(userDetails.getHpNo());
		}
		if (userDetails.getPost() != null) {
			user.setPost(userDetails.getPost());
		}
		if (userDetails.getAddr1() != null) {
			user.setAddr1(userDetails.getAddr1());
		}
		if (userDetails.getAddr2() != null) {
			user.setAddr2(userDetails.getAddr2());
		}
		if (userDetails.getUserDesc() != null) {
			user.setUserDesc(userDetails.getUserDesc());
		}
		if (userDetails.getUserDesc2() != null) {
			user.setUserDesc2(userDetails.getUserDesc2());
		}
		if (userDetails.getBirthYmd() != null) {
			user.setBirthYmd(userDetails.getBirthYmd());
		}
		if (userDetails.getMktRecYn() != null) {
			user.setMktRecYn(userDetails.getMktRecYn());
		}
		if (userDetails.getContractYn() != null) {
			user.setContractYn(userDetails.getContractYn());
		}
		if (userDetails.getProfileFile() != null) {
			user.setProfileFile(userDetails.getProfileFile());
		}

		user.setUpdateDt(LocalDateTime.now());

		return userRepository.save(user);
	}

	public void deleteUser(Integer userSeq) {
		User user = getUserBySeq(userSeq);
		// 논리적 삭제 처리
		user.setUserDelGu("Y");
		user.setUserDelDt(LocalDateTime.now());
		userRepository.save(user);
	}
}