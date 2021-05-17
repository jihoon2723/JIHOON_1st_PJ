package jihoon.planner_web.controller;

import jihoon.planner_web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class memberController {
    private final MemberService memberService;

    @Autowired
    public memberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/member/login_joinForm.html")
    public String login() {
        return "member/login_joinForm";
    }
}
