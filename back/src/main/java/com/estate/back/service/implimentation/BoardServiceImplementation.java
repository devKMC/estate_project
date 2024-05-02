package com.estate.back.service.implimentation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.estate.back.dto.request.board.PostBoardRequestDto;
import com.estate.back.dto.response.ResponseDto;
import com.estate.back.dto.response.board.GetBoardListResponseDto;
import com.estate.back.entity.BoardEntity;
import com.estate.back.repository.BoardRepository;
import com.estate.back.repository.UserRepository;
import com.estate.back.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 2.의존성 주입을 위한 어노테이션
public class BoardServiceImplementation implements BoardService {

    // 1.코드 작성할때 필요한 의존성 주입 
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;


    @Override
    public ResponseEntity<ResponseDto> postBoard(PostBoardRequestDto dto, String userId) {
    

        try{
            boolean isExistUser = userRepository.existsById(userId); //3. userId의 존재검증 코드
            if(!isExistUser) return ResponseDto.authenticationFailed(); 

            //4. 존재한다면 데이터를 삽입하는 코드
            BoardEntity boardEntity = new BoardEntity(dto, userId); //5. 값을 매개변수로 바로 넘김 
            //6. BoardEntity 파일 안에 받아 올수 있게끔 작성

            // 11. Board Entity에서 생성된 Date를 저장
            boardRepository.save(boardEntity);


        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        // 성공 내보내기
        return ResponseDto.success();
    }


    @Override
    public ResponseEntity<? super GetBoardListResponseDto> getBoardList() {

        try {
            List<BoardEntity> boardEntities = boardRepository.
            findByorderByReceptionNumberDesc();

            return GetBoardListResponseDto.success(boardEntities);
        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

    }



}
