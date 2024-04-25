package com.estate.back.entity;

import com.estate.back.dto.request.auth.SignUpRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Estate 데이터베이스의 user 테이블과 매핑되는 Entity 클래스 
@Entity(name="user")
@Table(name="user") // 매핑되는 테이블의 이름은 user , 클래스명하고 테이블명이 다르기 때문에 지정
@Getter // DB에서 받아오기 위한 작업
@Setter
@NoArgsConstructor
@AllArgsConstructor


// 여기까지 작성 후 유저 엔터티로 레포지토리 생성

public class UserEntity {

    // 데이터베이스에 5개의 컬럼이 존재함
    @Id // UserId의 기본키 지정 
    private String userId; 
    private String userPassword;
    private String userEmail;
    private String userRole;
    private String joinPath;

    // 새로운 생성자 작성 (implement 서비스에서 쓰기 위해)
    public UserEntity(SignUpRequestDto dto){
        this.userId = dto.getUserId();
        this.userPassword = dto.getUserPassword();
        this.userEmail = dto.getUserEmail();
        this.userRole = "ROLE_USER";
        this.joinPath = "HOME";
    }
}

