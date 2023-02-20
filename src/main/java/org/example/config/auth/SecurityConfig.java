package org.example.config.auth;

import lombok.RequiredArgsConstructor;
import org.example.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor    // final 선언 된 필드 생성자 자동생성
@EnableWebSecurity      // Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()  // h2-console 화면을 위해서 옵션 disable
                .and()
                    .authorizeRequests()  // URL 별 권한 관리를 위한 옵션 활성화
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())    // antMatchers 옵션으로 권한 관리 대상 지정, URL/HTTP 메소드별 관리 가능
                    .anyRequest().authenticated()   // anyRequest 설정된 값 이외 나머지 URL, 인증된 사용자에게만 허용함
                .and()
                    .logout()
                        .logoutSuccessUrl("/")  // 로그아웃 성공 시 "/" 로 돌아감
                .and()
                    .oauth2Login()  // OAuth2 로그인 기능에 대한 설정 진입점
                        .userInfoEndpoint() // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정 담당
                            .userService(customOAuth2UserService);  // 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스 구현체 등록
    }
}
