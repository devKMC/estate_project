package com.estate.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.estate.back.entity.BoardEntity;


// estate 데이터베이스의 board 테이블의 작업을 위한 리포지토리
// 보드의 엔티티에 기본키를 보면 Integer로 설정되어 있음.
@Repository
public interface BoardRepository extends JpaRepository<BoardEntity,Integer> {
    List<BoardEntity> findByOrderByReceptionNumberDesc();

    // Contains / Containing / IsContaining => LIKE '%word%'
    // StartingWith => LIKE 'word%'
    // EndingWith => LIKE '%word'
    List<BoardEntity> findByTitleContainsOrderByReceptionNumberDesc(String title);
    BoardEntity findByReceptionNumber(Integer receptionNumber);

}
