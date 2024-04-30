package com.estate.back.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.estate.back.dto.response.user.GetSignInUserResponseDto;

@Service
public interface UserService {
    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser (String userId);
}

