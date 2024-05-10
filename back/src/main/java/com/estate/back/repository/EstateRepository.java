package com.estate.back.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.estate.back.entity.EstateEntity;
import com.estate.back.repository.resultSet.GetLocalDataResultSet;
import com.estate.back.repository.resultSet.GetRatioDataResultSet;

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
    
    @Query (value= 
    "SELECT `year_month` as yearMonth, " +
    "return40, return4060, return6085, return85 , " +
    "lease_ratio40 as 'leaseRatio40', " +
    "lease_ratio4060 as 'leaseRatio4060', " +
    "lease_ratio6085 as 'leaseRatio6085', " +
    "lease_ratio85 as 'leaseRatio85', " +
    "month_rent_ratio40 as 'monthRentRatio40', " +
    "month_rent_ratio4060 as 'monthRentRatio4060', " +
    "month_rent_ratio6085 as 'monthRentRatio6085', " +
    "month_rent_ratio85 as 'monthRentRatio85' " +
    "FROM estate " +
    "WHERE `year_month` BETWEEN '2023-01-01' AND '2023-12-30' " +
    "AND `local` = 'BUSAN'; ",
    nativeQuery=true
    )
    List<GetRatioDataResultSet> getRatioData (@Param("local")String local);

}
