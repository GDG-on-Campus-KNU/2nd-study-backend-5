package GDSCBackend5.HappyNewYear.server.controller;

import GDSCBackend5.HappyNewYear.server.domain.Post;
import GDSCBackend5.HappyNewYear.server.domain.member.Member;
import GDSCBackend5.HappyNewYear.server.domain.member.SessionConst;
import GDSCBackend5.HappyNewYear.server.service.MemberService;
import GDSCBackend5.HappyNewYear.server.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.*;

@Controller
@RequiredArgsConstructor
public class HomeController {
    @Autowired
    private PostService postService;
    private final MemberService memberService;
    @GetMapping("/")
    public String home(HttpServletResponse response,@SessionAttribute(name= SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {
        if (loginMember == null) {
            return "/home";
        }
        //쿠키  객체 생성, "cookieName"이라는 이름으로 쿠키를 생성하고, 그 값은 "cookieValue"로 설정
        Cookie tokenCookie = new Cookie("token", loginMember.getToken());

        // 쿠키 경로 설정, "/"는 모든 경로에서 사용하겠다는 뜻
        tokenCookie.setPath("/");

        // 쿠키를 유지할 시간 설정(단위 : 초)
        tokenCookie.setMaxAge(60*60*24*30); // 30일 동안 쿠키 유지.

        response.addCookie(tokenCookie);
        model.addAttribute("loginMember", loginMember);
        return "/home";
    }



}
