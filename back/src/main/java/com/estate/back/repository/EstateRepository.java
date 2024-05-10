package com.estate.back.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.estate.back.entity.EstateEntity;
import com.estate.back.repository.resultSet.GetLocalDataResultSet;

@Repository
public interface EstateRepository extends JpaRepository<EstateEntity, Integer> { // EstateEntity 를 가져오는데 타입을 Integer

    // 쿼리 작성시 가장 끝에 스페이스바 한칸 작성
    // 많은 필드 중에 4개의 컬럼만 받으려고 엔터티를 사용하지 않고 필요한것만 받는 법
    // 컬럼에 `` 하는 이유 : 속성은 원래 `` 하는게 좋음

    @Query (value=
    "SELECT `year_month` as yearMonth,sale, lease, month_rent as monthRent " +
    "FROM estate " +
    "WHERE `year_month` BETWEEN '2023-01-01' AND '2023-12-01' " +
    "AND `local` = :local ",
    nativeQuery=true
    )
    List<GetLocalDataResultSet> getLocalData(@Param("local") String local);
    
}

