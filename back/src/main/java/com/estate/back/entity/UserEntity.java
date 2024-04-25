package com.estate.back.entity;

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

public class UserEntity {

    // 데이터베이스에 5개의 컬럼이 존재함
    @Id // UserId의 기본키 지정 
    private String userId; 
    private String userPassword;
    private String userEmail;
    private String userRole;
    private String joinPath;
}

// 유저 엔터티로 레포지토리 생성