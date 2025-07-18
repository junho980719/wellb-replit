package kr.co.wellbe.domain.entity.user;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ORG_INFO")
public class OrgInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORG_SEQ", nullable = false, columnDefinition = "INT COMMENT '기관순번'")
    private Integer orgSeq;

    @Column(name = "ORG_NAME", length = 500, columnDefinition = "VARCHAR(500) COMMENT '협회_기관_센터명'")
    private String orgName;

    @Column(name = "BIZ_NO", length = 20, columnDefinition = "VARCHAR(20) COMMENT '사업자등록번호_선터'")
    private String bizNo;

    @Column(name = "REP_NM", length = 200, columnDefinition = "VARCHAR(200) COMMENT '대표자성명'")
    private String repNm;

    @Column(name = "AREA", length = 200, columnDefinition = "VARCHAR(200) COMMENT '소재지'")
    private String area;

    @Column(name = "MNG_POSIT", length = 200, columnDefinition = "VARCHAR(200) COMMENT '담당자직책'")
    private String mngPosit;

    @Column(name = "MNG_PHONE", length = 20, columnDefinition = "VARCHAR(20) COMMENT '담당자연락처'")
    private String mngPhone;

    @Column(name = "MNG_EMAIL", length = 200, columnDefinition = "VARCHAR(200) COMMENT '담당자에메일'")
    private String mngEmail;

    @Column(name = "UPTAE", length = 500, columnDefinition = "VARCHAR(500) COMMENT '업태(센터)'")
    private String uptae;

    @Column(name = "JONG", length = 500, columnDefinition = "VARCHAR(500) COMMENT '종목(선터)'")
    private String jong;

    @Column(name = "MNG_NM", length = 200, columnDefinition = "VARCHAR(200) COMMENT '담당자명'")
    private String mngNm;

    @Column(name = "POST", length = 20, columnDefinition = "VARCHAR(20) COMMENT '우편번호'")
    private String post;

    @Column(name = "ADDR1", length = 200, columnDefinition = "VARCHAR(200) COMMENT '주소1'")
    private String addr1;

    @Column(name = "ADDR2", length = 200, columnDefinition = "VARCHAR(200) COMMENT '주소2'")
    private String addr2;

    @Column(name = "ORG_GU", length = 20, columnDefinition = "VARCHAR(20) COMMENT '기관회원구분코드'")
    private String orgGu;

    @Column(name = "REG_NO", length = 20, columnDefinition = "VARCHAR(20) COMMENT '고유번호_협회_기관'")
    private String regNo;

    @Column(name = "INPUT_DT", columnDefinition = "TIMESTAMP COMMENT '입력일시'")
    private LocalDateTime inputDt;

    @Column(name = "UPDATE_DT", columnDefinition = "TIMESTAMP COMMENT '수정일시'")
    private LocalDateTime updateDt;

    @Column(name = "MEM_COND", length = 500, columnDefinition = "VARCHAR(500) COMMENT '회원가입조건'")
    private String memCond;

    @Column(name = "UPDATE_USER_SEQ", columnDefinition = "INT COMMENT '최종수정자순번'")
    private Integer updateUserSeq;
}
