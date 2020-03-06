package com.macxpaik.springbootboard.signuplogin.controller;

import com.macxpaik.springbootboard.signuplogin.dto.MemberDto;
import com.macxpaik.springbootboard.signuplogin.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user/signup")
    public String dispSignup() {
        return "user/signup";
    }

    @PostMapping("/user/signup")
    public String execSignup(MemberDto memberDto) {
        memberService.joinUser(memberDto);

        return "redirect:/user/login";
    }

    @GetMapping("/user/login")
    public String dispLogin() {
        return "user/login";
    }

    @GetMapping("/user/login/result")
    public String dispLoginResult() {
        return "user/loginSuccess";
    }

    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "user/logout";
    }

    @GetMapping("/user/denied")
    public String dispDenied() {
        return "user/denied";
    }

    @GetMapping("/user/info")
    public String dispMyInfo() {
        return "user/myinfo";
    }

    @GetMapping("/admin")
    public String dispAdmin() {
        return "user/admin";
    }
}