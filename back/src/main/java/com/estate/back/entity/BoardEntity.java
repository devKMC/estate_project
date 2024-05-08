package com.estate.back.entity;

//8 (게시판) Date 임포트
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import com.estate.back.dto.request.board.PostBoardRequestDto;
import com.estate.back.dto.request.board.PutBoardRequsetDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Estate 데이터베이스의 board 테이블과 매핑되는 Entity 클래스
@Entity(name="board")
@Table(name="board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer receptionNumber;
    private Boolean status;
    private String title;
    private String contents;
    private String writerId;
    private String writeDatetime;
    private Integer viewCount;
    private String comment;

    // 7 (게시판)
    public BoardEntity(PostBoardRequestDto dto, String userId){
        // 9 (게시판)
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDatetime = simpleDateFormat.format(now);


        this.status = false;
        this.title = dto.getTitle(); // 클라이언트로 부터 받아야 할 것들  1
        this.contents = dto.getContents(); //받아야 할것들 2
        this.writerId = userId;
        


        // 10 (게시판)
        this.writeDatetime = writeDatetime;
        this.viewCount = 0;
    }

    // 조회수 1 증가 코드
    public void increaseViewCount(){
        this.viewCount++;
    }

    public void update(PutBoardRequsetDto dto) {
        this.title = dto.getTitle();
        this.contents = dto.getContents();
    }
}
