package jihoon.planner_web.service;

import jihoon.planner_web.domain.MemberInfo;
import jihoon.planner_web.dto.MemberInfoDto;
import jihoon.planner_web.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;


    /*
     * Spring Security 필수 메소드 구현
     *
     * @param email 이메일
     * @return UserDetails
     * @throws UsernameNotFoundException 유저가 없을 때 예외 발생
     * */
    @Override // 기본적인 반환 타입은 UserDetails, UserDetails를 상속받은 MemberInfo로 반환 타입 지정(자동으로 다운캐스팅 됨)
    public MemberInfo loadUserByUsername(String email) throws UsernameNotFoundException { //시큐리티에서 지정한 서비스이기 때문에 이 메소드를 필수로 구현
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException((email)));
    }


    /*
    * 회원정보 저장
    * @param infoDto 회원정보가 들어있는 DTO
    * @return 저장되는 회원의 PK
    * */
    public  Long save(MemberInfoDto infoDto){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        infoDto.setPassword(encoder.encode(infoDto.getPassword()));

        return memberRepository.save(MemberInfo.builder()
            .email(infoDto.getEmail())
            .auth(infoDto.getAuth())
            .name(infoDto.getName())
            .password(infoDto.getPassword()).build()).getId();

    }
    public boolean checkEmailDuplicate(String email){
        return memberRepository.existsByEmail(email);
    }

}
