package jihoon.planner_web.domain;

import jihoon.planner_web.service.MemberService;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "zp_user")
public class MemberInfo implements UserDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "auth")
    private String auth;

    @Builder
    public MemberInfo(String email,String name,String password,String auth){
        this.email=email;
        this.name=name;
        this.password=password;
        this.auth=auth;
    }

    //사용자의 권한을 콜렉션 형태로 변환
    //단, 클래스 자료형은 GrantedAuthority를 구현해야함
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();   //Set<GrantedAuthority> <<권한이 중복되면 안되기때문에  /현재는 권한이 user만 있기때문에 필요없지만 나중을 위해 해놓음
        for (String role : auth.split(",")){
            roles.add(new SimpleGrantedAuthority(role));
        }
        return roles;
    }
    //사용자의 id반환 (unique한 값)
    @Override
    public String getUsername() {
        return email;
    }
    //사용자의 password 반환
    @Override
    public String getPassword() {
        return password;
    }
    
    //계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired() {
        //만료되었는지 확인하는 로직
        return true;   //true -> 만료되지 않았음
    }
    //계정 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked() {
        //계정 잠금되었는지 확인하는 로직
        return true; // true -> 잠금되지 않음
    }
    //패스워드의 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired() {
        // 패스워드가 만료되었는지 확인하는 로직
        return true; //true -> 만료되지 않았음
    }
    //계정 사용 가능 여부 반환
    @Override
    public boolean isEnabled() {
        // 계정이 사용 가능한지 확인하는 로직
        return true;  //true -> 사용 가능
    }
}
