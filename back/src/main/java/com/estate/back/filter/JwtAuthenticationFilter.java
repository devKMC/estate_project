package com.estate.back.filter;

import java.io.IOException;

import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Spring Security Filter Chain에 추가할 JWT 필터 
// - Request 객체로부터 header 정보를 받아와서 Header에 있는 Authorized 필드의 Bearer 토큰 값을 가져와서 JWT 검증
// - 접근 주체의 권한을 확인하여 권한 등록 추가

// 커스텀 생성 하려면 OncePerRequestFilter으로 클래스를 확장해줘야함 
// JwtAuthenticationFilter를 필수로 해야되는 오버라이딩 자동 작업 클릭
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    // * 아래의 코드는 JwtAuthenticationFilter의 실제 동작
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {

            // Request 객체에서 Bearer 토큰 값 가져오기
            // token에 올 수 있는 데이터로는 token , null 이 올 수 있기에 null 이 왔을땐 동작을 하지 못하게 if문으로 작업함
            String token = parseBearerToken(request);
            if (token== null){
                filterChain.doFilter(request, response);
                return;
            }

        } catch (Exception exception) {
            // 예외 발생 시
            exception.printStackTrace();
        }
            // 이 작업을 해줘야 동작함 (리턴과 같은 역활을 함)
        filterChain.doFilter(request, response);
    }

    // Request 객체에서 Bearer 토큰 값을 가져오는 메서드 생성
    private String parseBearerToken(HttpServletRequest request) {

        // request 객체에서 header 에서 Authorization 필드 값 추출
        String authorization = request.getHeader("Authorization");

        // Authorization 필드값 존재 여부 확인
        // 존재하지 않는다면 null 반환
        boolean hasAuthorization = StringUtils.hasText(authorization);
        if (!hasAuthorization)
            return null;

        // barrer 인증 여부 확인 / 띄어쓰기 있으니 확인해야 함
        // 존재하지 않는다면 null 반환
        boolean isBearer = authorization.startsWith("Bearer ");
        if (!isBearer)
            return null;

        // Authorization 필드 값에서 토큰 추출
        // 뒤에서 7자리까지 토큰 값을 가져옴
        String token = authorization.substring(7);
        return token;

    }

}
