package jihoon.planner_web.auth;

import jihoon.planner_web.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity    //spring security를 적용하는 annotation
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MemberService memberService;
    /*
    * 규칙 설정
    * @param http
    * @throws Exception
    * */
    @Override
    public void configure(WebSecurity web) { // 4
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/userAccess").hasRole("USER")  // USER만 접근 가능
                .antMatchers("/signUp").anonymous()     //인증되지 않은 즉, 로그인 되지 않은 사용자만 접근 가능
                .and()
                .formLogin()  //spring security에서 제공하는 login form 이용한다는 뜻, 로그인 성공시 '/'로 리다이렉트
                .and()
                .logout()
                .logoutSuccessUrl("/login") //로그아웃 성공시 리다이렉트 주소
                .invalidateHttpSession(true);  //세션 날리기
    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(memberService).passwordEncoder(new BCryptPasswordEncoder());
        // 해당 서비스(userService)에서는 UserDetailService를 implements해서 loadUserByUsername()을 구현해야함함
   }

}
