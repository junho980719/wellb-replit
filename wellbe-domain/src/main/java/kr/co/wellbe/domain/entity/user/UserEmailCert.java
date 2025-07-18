package kr.co.wellbe.domain.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "USER_EMAIL_CERT")
public class UserEmailCert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMAIL_CERT_SEQ", nullable = false, columnDefinition = "INT COMMENT '이메일인증순번'")
    private Integer emailCertSeq;

    @Column(name = "USER_ID", length = 200, columnDefinition = "VARCHAR(200) COMMENT 'USER_ID'")
    private String userId;

    @Column(name = "USER_NM", length = 200, columnDefinition = "VARCHAR(200) COMMENT '사용자명'")
    private String userNm;

    @Column(name = "EMAIL", length = 500, columnDefinition = "VARCHAR(500) COMMENT '이메일'")
    private String email;

    @Column(name = "RANDOM_ID", length = 500, columnDefinition = "VARCHAR(500) COMMENT '전송랜덤번호'")
    private String randomId;

    @Column(name = "EMAIL_CHK_YN", length = 1, columnDefinition = "VARCHAR(1) COMMENT '이메일확인여부'")
    private String emailChkYn;
}
