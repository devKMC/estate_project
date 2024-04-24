package com.estate.back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Estate 데이터베이스의 email_auth_number 테이블과 매핑되는 Entity 클래스
@Entity(name="emailAuthNumber") // 다른 엔터티로 사용하기 위한 지정
@Table(name="email_auth_number") // 매핑되는 테이블의 이름
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmailAuthNumberEntity {
    @Id // PK 로 email 지정 ( DB에 기본키로 잡혀 있음 )
    private String email;
    private String authNumber;
}
