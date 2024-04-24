package com.estate.back.service;

import org.springframework.http.ResponseEntity;

import com.estate.back.dto.request.auth.IdCheckRequestDto;
import com.estate.back.dto.response.ResponseDto;

public interface AuthService {
    //리스폰스객체를 반환
    ResponseEntity<ResponseDto> idCheck (IdCheckRequestDto dto); // 여기까지 작성후 implementation 구현
    
}
