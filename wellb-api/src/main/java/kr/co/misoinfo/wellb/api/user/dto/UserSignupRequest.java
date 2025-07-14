
package kr.co.misoinfo.wellb.api.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class UserSignupRequest {
    
    @NotBlank(message = "이름을 입력해주세요")
    private String name;
    
    @NotNull(message = "생년월일을 입력해주세요")
    private LocalDate birthdate;
    
    @NotBlank(message = "성별을 선택해주세요")
    private String gender;
    
    @NotBlank(message = "연락처를 입력해주세요")
    @Pattern(regexp = "^010-\\d{4}-\\d{4}$", message = "올바른 연락처 형식이 아닙니다")
    private String phone;
    
    @NotBlank(message = "이메일을 입력해주세요")
    @Email(message = "올바른 이메일 형식이 아닙니다")
    private String email;
    
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;
    
    private Boolean marketingConsent = false;
    
    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public LocalDate getBirthdate() { return birthdate; }
    public void setBirthdate(LocalDate birthdate) { this.birthdate = birthdate; }
    
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public Boolean getMarketingConsent() { return marketingConsent; }
    public void setMarketingConsent(Boolean marketingConsent) { this.marketingConsent = marketingConsent; }
}
