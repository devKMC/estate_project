package com.estate.back.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estate.back.dto.request.auth.EmailAuthCheckRequestDto;
import com.estate.back.dto.request.auth.EmailAuthRequestDto;
import com.estate.back.dto.request.auth.IdCheckRequestDto;
import com.estate.back.dto.response.ResponseDto;
import com.estate.back.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

// Auth 모듈 컨트롤러 : /api/v1/auth
@RestController // JSON 형태의 리스폰스를 반환하려고 할 때 사용
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor // AuthService 의존성 주입을 위해 작업
public class AuthController {

    //AuthService 의존성 
    private final AuthService authService;

    @PostMapping("/id-check")
    public ResponseEntity<ResponseDto> idCheck(
        @RequestBody @Valid IdCheckRequestDto requestBody
        ) {
            ResponseEntity<ResponseDto> response = authService.idCheck(requestBody);
            return response;
    }

    // 이메일 인증 
    @PostMapping("/email-auth")
    public ResponseEntity<ResponseDto> emailAuth (
        @RequestBody @Valid EmailAuthRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response = authService.emailAuth(requestBody);
        return response;
    }

    // 이메일 인증 확인
    @PostMapping("/email-auth/check")
    // body의 형태가 responseDto
    public ResponseEntity<ResponseDto> emailAuthCheck(
                // @RequestBody로 받기 위해 ,valid = 유효성 검사
                @RequestBody @Valid EmailAuthCheckRequestDto requsetBody
    ){
        ResponseEntity<ResponseDto> response = authService.emailAuthCheck(requsetBody);
        return response;
    }
}
