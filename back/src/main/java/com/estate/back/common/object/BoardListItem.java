package com.estate.back.common.object;

import com.estate.back.entity.BoardEntity;

import java.text.SimpleDateFormat;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import lombok.Getter;

@Getter
public class BoardListItem {
    private Integer receptionNumber;
    private Boolean status;
    private String title;
    private String writerId;
    private String writeDatetime;
    private Integer viewCount;

    // 생 성 자
    // 데이터베이스에서 전체 리스트를 조회하는 작업 - 결과로 List<BoardEntity> - List<BoardListItem>
    private BoardListItem(BoardEntity boardEntity) throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); // DB의 현재 타입
        Date datetime = simpleDateFormat.parse(boardEntity.getWriteDatetime()); // String -> datetime으로 변경
        simpleDateFormat = new SimpleDateFormat("yy.MM.dd"); // writerDatetime 형태로 변환
        String writeDatetime = simpleDateFormat.format(datetime); // 형태 변경후 writeDatetime으로 전달 YYYY-MM-dd hh:mm:ss -> yy.MM.dd

        String writerId = boardEntity.getWriterId(); // 엔티티에서 writeId 가져옴
        writerId = writerId.substring(0,1) + "*".repeat(writerId.length()-1); // 첫번째 글자들만 가져와서 반복작업 진행

        this.receptionNumber = boardEntity.getReceptionNumber();
        this.status = boardEntity.getStatus();
        this.title = boardEntity.getTitle();
        this.writerId = writerId;
        this.writeDatetime = writeDatetime;
        this.viewCount = boardEntity.getViewCount();
    }

    public static List<BoardListItem> getList(List<BoardEntity>boardEntities) throws Exception{  
        List<BoardListItem> boardList = new ArrayList<>(); // 빈 배열 만들기

        for (BoardEntity boardEntity : boardEntities){ // List<BoardEntity>를 하나씩 꺼내오면서 단일 리스트를 만들어준다.
            BoardListItem boardListItem = new BoardListItem(boardEntity); // 인스턴스 생성
            boardList.add(boardListItem); // 보드 리스트에 차곡차곡 쌓음
        }

        return boardList;

    }
}
