package com.estate.back.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

//  Spring Web Security 설정
// - Basic 인증 미사용 으로 변경
// - CSRF 정책 미사용
// - Session 생성 정책 미사용
// - CORS 정책 (모든 출처 - 모든 메서드 - 모든 패턴 허용)

@Configurable
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    protected SecurityFilterChain configure(HttpSecurity httpSecurity)
            throws Exception {
        httpSecurity
                .httpBasic(HttpBasicConfigurer::disable) //Basic 미사용
                .csrf(CsrfConfigurer::disable) //CSRF 미사용
                .sessionManagement(sessionManagement -> sessionManagement // 받아온 sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(cors -> cors
                        .configurationSource(corsConfigurationSource())
                        );

                return httpSecurity.build(); // 적용
    }

    // Cors 정책 설정
    // CORS 정책 (모든 출처 - 모든 메서드 - 모든 패턴 허용)

    @Bean
    protected CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*"); // * 모든것 허용
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;

    }
}
