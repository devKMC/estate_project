package com.estate.back.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.estate.back.dto.response.ResponseDto;

// Request의 데이터 유효성 검사에서 발생하는 예외 처리
// (데이터베이스 작업 중 에러가 발생하면 'DBE' 응답 처리 )

@RestControllerAdvice
public class ValidationExceptionHandler {
    
    public ResponseEntity<ResponseDto> validationExceptionHandler() {
        return ResponseDto.validationFailed();
    }

}
