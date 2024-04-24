package com.estate.back.service.implimentation;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.estate.back.dto.request.auth.IdCheckRequestDto;
import com.estate.back.dto.response.ResponseDto;
import com.estate.back.repository.UserRepository;
import com.estate.back.service.AuthService;

import lombok.RequiredArgsConstructor;

// Auth 모듈의 비즈니스 로직 구현체


@Service // 이 클래스를 서비스 클래스로 사용하기 위함
@RequiredArgsConstructor // 20번행의 의존성 주입을 위해 사용
public class AuthServiceImplimentation implements AuthService{

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto) {
        
        //user 테이블에서 해당하는 userEmail를 가지고 있는 유저가 있는지 확인 할때는 반드시 예외가 발생할 수 있어 try catch 작업
        try{
            // user Id 를 가져오는 작업
            String userId= dto.getUserId();
            // 확인할 때는 boolean 으로 있다 없다만 작업해주면 된다.
            boolean existedUser = userRepository.existsById(userId);
            if (existedUser) return ResponseDto.duplicatedId();

        }catch (Exception exception){
            exception.printStackTrace();
            // 스태틱으로 지정했기에 databaseError를 바로 사용할 수 있음
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }
    
}
