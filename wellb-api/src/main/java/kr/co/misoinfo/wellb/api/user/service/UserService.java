
package kr.co.misoinfo.wellb.api.user.service;

import kr.co.misoinfo.wellb.api.user.dto.UserSignupRequest;
import kr.co.misoinfo.wellb.api.user.entity.User;
import kr.co.misoinfo.wellb.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public User signup(UserSignupRequest request) {
        // 이메일 중복 체크
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("이미 사용중인 이메일입니다.");
        }
        
        // 연락처 중복 체크
        if (userRepository.existsByPhone(request.getPhone())) {
            throw new RuntimeException("이미 사용중인 연락처입니다.");
        }
        
        // User 엔티티 생성
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // 실제로는 암호화 필요
        user.setPhone(request.getPhone());
        user.setBirthdate(request.getBirthdate());
        user.setGender(User.Gender.valueOf(request.getGender().toUpperCase()));
        user.setMarketingConsent(request.getMarketingConsent());
        
        return userRepository.save(user);
    }
    
    public boolean checkEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }
    
    public boolean checkPhoneExists(String phone) {
        return userRepository.existsByPhone(phone);
    }
}
