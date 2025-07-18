package kr.co.wellbe.user.app.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    private String userId;
    private String pwd;
    private String userNm;
    private String hpNo;
    private String email;
    private String birthYmd;
    private String mktRecYn;
    private String sex;
}
