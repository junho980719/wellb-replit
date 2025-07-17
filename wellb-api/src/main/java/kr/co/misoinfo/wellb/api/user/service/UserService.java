
package kr.co.misoinfo.wellb.api.user.service;

import kr.co.misoinfo.wellb.api.user.dto.UserSignupRequest;
import kr.co.misoinfo.wellb.app.domain.user.User;
import kr.co.misoinfo.wellb.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.misoinfo.wellb.common.exception.BusinessException;
import kr.co.misoinfo.wellb.common.exception.ErrorCode;
import java.time.format.DateTimeFormatter;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public User signup(UserSignupRequest request) {
        // 이메일 중복 체크
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BusinessException(ErrorCode.DUPLICATE_EMAIL);
        }
        
        // 연락처 중복 체크
        if (userRepository.existsByPhone(request.getPhone())) {
            throw new BusinessException(ErrorCode.DUPLICATE_PHONE);
        }
        
        // User 엔티티 생성
        User user = new User();
        user.setUserNm(request.getName());
        user.setEmail(request.getEmail());
        user.setPwd(request.getPassword()); // 실제로는 암호화 필요
        user.setHpNo(request.getPhone());
        
        // LocalDate to String (YYYYMMDD)
        if (request.getBirthdate() != null) {
            user.setBirthYmd(request.getBirthdate().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        }
        
        // MarketingConsent Boolean to String (Y/N)
        user.setMktRecYn(request.getMarketingConsent() ? "Y" : "N");

        // Set userId to email for now, as there's no separate userId in signup request
        user.setUserId(request.getEmail());
        
        return userRepository.save(user);
    }
    
    public boolean checkEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }
    
    public boolean checkPhoneExists(String phone) {
        return userRepository.existsByPhone(phone);
    }
}
