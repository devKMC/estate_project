package com.estate.back.service;

import org.springframework.http.ResponseEntity;

import com.estate.back.dto.request.board.PostBoardRequestDto;
import com.estate.back.dto.request.board.PostCommentRequestDto;
import com.estate.back.dto.response.ResponseDto;
import com.estate.back.dto.response.board.GetBoardListResponseDto;
import com.estate.back.dto.response.board.GetBoardResponseDto;
import com.estate.back.dto.response.board.GetSearchBoardListResponseDto;

public interface BoardService {
    
    //응답에 대한 반응에 대해 작성
    // CREATE
    ResponseEntity<ResponseDto>postBoard (PostBoardRequestDto dto, String userId); //userId 는 JWT를 통해 따로 받아옴
    ResponseEntity<ResponseDto>postComment (PostCommentRequestDto dto , int receptionNumber);

    // READ
    ResponseEntity<? super GetBoardListResponseDto>getBoardList();
    ResponseEntity<? super GetSearchBoardListResponseDto>getSearchBoardList(String searchWord); // (검색어)를 매개변수로 받아와야함 
    ResponseEntity<? super GetBoardResponseDto> getBoard(int receptionNumber);

    // UPDATE
    ResponseEntity<ResponseDto> increaseViewCount(int receptionNumber);

    // DELETE
    ResponseEntity<ResponseDto> deleteBoard(int receptionNumber,String userId); //접수번호와, 접근 주체의 아이디
}
