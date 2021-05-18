package jihoon.planner_web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberInfoDto {
    private String email;
    private String name;
    private String password;
    private String auth;
}
