package com.estate.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estate.back.dto.request.board.PostBoardRequestDto;
import com.estate.back.dto.response.ResponseDto;
import com.estate.back.service.BoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor     // 의존성 주입 어노테이션
public class BoardController {
    
    // 의존성 주입
    private final BoardService boardService;
    
    @PostMapping("/") // / 반환타입
    ResponseEntity<ResponseDto> postBoard (
        @RequestBody @Valid PostBoardRequestDto requestBody,
        @AuthenticationPrincipal String userId // 토큰 인증 결과값을 가져옴
        
    ){
        ResponseEntity<ResponseDto> response = boardService.postBoard(requestBody, userId); // requestBody, userId 호출해서 반환
        return response;
    }

}
