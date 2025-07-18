package kr.co.wellbe.domain.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "USER_GB_CODE")
public class UserType {
    @Id
    private String gbCd;

    private String gbNm;

    @Column(name = "INPUT_DT")
    private LocalDateTime inputDt;

    @Column(name = "UPDATE_DT")
    private LocalDateTime updateDt;

}
