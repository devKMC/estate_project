package com.estate.back.service.implimentation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.estate.back.dto.request.board.PostBoardRequestDto;
import com.estate.back.dto.request.board.PostCommentRequestDto;
import com.estate.back.dto.response.ResponseDto;
import com.estate.back.dto.response.board.GetBoardListResponseDto;
import com.estate.back.dto.response.board.GetBoardResponseDto;
import com.estate.back.dto.response.board.GetSearchBoardListResponseDto;
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

        try {
            boolean isExistUser = userRepository.existsById(userId); // 3. userId의 존재검증 코드
            if (!isExistUser)
                return ResponseDto.authenticationFailed();

            // 4. 존재한다면 데이터를 삽입하는 코드
            BoardEntity boardEntity = new BoardEntity(dto, userId); // 5. 값을 매개변수로 바로 넘김
            // 6. BoardEntity 파일 안에 받아 올수 있게끔 작성

            // 11. Board Entity에서 생성된 Date를 저장
            boardRepository.save(boardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        // 성공 내보내기
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetBoardListResponseDto> getBoardList() {

        try {
            List<BoardEntity> boardEntities = boardRepository.findByOrderByReceptionNumberDesc();

            return GetBoardListResponseDto.success(boardEntities);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

    }

    // 검 색 어 관 련
    @Override
    public ResponseEntity<? super GetSearchBoardListResponseDto> getSearchBoardList(String searchWord) {

        try { // 성 공 리 턴(밖이나 안이 상관 없음)
            List<BoardEntity> boardEntities = boardRepository.findByTitleContainsOrderByReceptionNumberDesc(searchWord);
            return GetSearchBoardListResponseDto.success(boardEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<? super GetBoardResponseDto> getBoard(int receptionNumber) {

        try { // 데이터베이스내용을 가져오기

            // board Entity와 null 이 들어올 수 있음
            BoardEntity boardEntity = boardRepository.findByReceptionNumber(receptionNumber);
            // 만약 null 이라면 유효성 검사를 통해 noExistBoard로 응답
            if (boardEntity == null)
                return ResponseDto.noExistBoard();

            return GetBoardResponseDto.success(boardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    // 조회수 작업을 따로 직접 함
    @Override
    public ResponseEntity<ResponseDto> increaseViewCount(int receptionNumber) {

        try {

            BoardEntity boardEntity = boardRepository.findByReceptionNumber(receptionNumber);
            if (boardEntity == null)
                return ResponseDto.noExistBoard(); // 만약 널이라면 없다는 표현을 반환

            boardEntity.increaseViewCount();
            boardRepository.save(boardEntity); // 증가한 조회수를 엔티티를 불러와서 레포지토리에 저장

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        // succeess exception 이없기때문에 직접 외부에서 성공 반환
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> postComment(PostCommentRequestDto dto, int receptionNumber) {
        
        try{

            BoardEntity boardEntity = boardRepository.findByReceptionNumber(receptionNumber);
            if (boardEntity == null) return ResponseDto.noExistBoard(); // 존재하지 않는 게시물로 내보내기

            boolean status = boardEntity.getStatus();
            if (status) return ResponseDto.writtenComment();

            String comment = dto.getComment();
            boardEntity.setStatus(true);
            boardEntity.setComment(comment);

            boardRepository.save(boardEntity);

        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteBoard(int receptionNumber, String userId) {


        try{

            // 접수 번호가 존재하는지 확인
            BoardEntity boardEntity = boardRepository.findByReceptionNumber(receptionNumber);
            if (boardEntity == null) return ResponseDto.noExistBoard();

            //작성자 아이디가 게시물 작성 아이디와 같은지 확인
            String writerId= boardEntity.getWriterId();
            boolean iswriter=userId.equals(writerId);
            if (!iswriter) return ResponseDto.authorizationFailed();

            // 위에 작업들 거친후 삭제는 delete 사용
            boardRepository.delete(boardEntity);

        }catch (Exception exception){
            exception.printStackTrace();
        }

        return ResponseDto.success();
    }

}
