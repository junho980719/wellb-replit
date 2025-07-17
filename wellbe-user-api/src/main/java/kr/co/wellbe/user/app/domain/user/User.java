
package kr.co.wellbe.user.app.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "USER_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	@Id
	@Column(name = "USER_SEQ")
	private Integer userSeq;

	@Column(name = "USER_ID", length = 200)
	private String userId;

	@Column(name = "PWD", length = 500)
	private String pwd;

	@Column(name = "USER_NM", length = 500)
	private String userNm;

	@Column(name = "POST", length = 20)
	private String post;

	@Column(name = "ADDR1", length = 500)
	private String addr1;

	@Column(name = "ADDR2", length = 500)
	private String addr2;

	@Column(name = "HP_NO", length = 20)
	private String hpNo;

	@Column(name = "EMAIL", length = 500)
	private String email;

	@Column(name = "GB_CD", length = 20, nullable = false)
	private String gbCd;

	@Column(name = "INPUT_DT")
	private LocalDateTime inputDt;

	@Column(name = "UPDATE_DT")
	private LocalDateTime updateDt;

	@Column(name = "EMAIL_CERT_SEQ", nullable = false)
	private Integer emailCertSeq;

	@Column(name = "USER_DEL_GU", length = 1)
	private String userDelGu;

	@Column(name = "USER_DEL_DT")
	private LocalDateTime userDelDt;

	@Column(name = "USER_DESC", length = 2000)
	private String userDesc;

	@Column(name = "USER_DESC2", length = 2000)
	private String userDesc2;

	@Column(name = "BIRTH_YMD", length = 8)
	private String birthYmd;

	@Column(name = "MKT_REC_YN", length = 1)
	private String mktRecYn;

	@Column(name = "CONTRACT_YN", length = 200)
	private String contractYn;

	@Column(name = "SUGG_USER_NO")
	private Integer suggUserNo;

	@Column(name = "ORG_SEQ", nullable = false)
	private Integer orgSeq;

	@Column(name = "PROFILE_FILE", length = 500)
	private String profileFile;
}
