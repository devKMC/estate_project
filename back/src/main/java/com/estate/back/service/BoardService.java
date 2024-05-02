package com.estate.back.service;

import org.springframework.http.ResponseEntity;

import com.estate.back.dto.request.board.PostBoardRequestDto;
import com.estate.back.dto.response.ResponseDto;

public interface BoardService {
    
    //응답에 대한 반응에 대해 작성
    ResponseEntity<ResponseDto>postBoard (PostBoardRequestDto dto, String userId); //userId 는 JWT를 통해 따로 받아옴
}
