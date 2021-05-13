package jihoon.planner_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class memberController {

    @GetMapping("/member/login_joinForm.html")
    public String login() {
        return "member/login_joinForm";
    }
}
