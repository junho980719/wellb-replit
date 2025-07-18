package kr.co.wellbe.domain.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "USER_GB_CODE")
public class UserGbCode {

    @Id
    @Column(name = "GB_CD", length = 20, nullable = false, columnDefinition = "VARCHAR(20) COMMENT '회원구분코드'")
    private String gbCd;

    @Column(name = "GB_NM", length = 200, columnDefinition = "VARCHAR(200) COMMENT '회원구분명'")
    private String gbNm;

    @Column(name = "INPUT_DT", columnDefinition = "TIMESTAMP COMMENT '입력일시'")
    private LocalDateTime inputDt;

    @Column(name = "UPDATE_DT", columnDefinition = "TIMESTAMP COMMENT '수정일시'")
    private LocalDateTime updateDt;
}
