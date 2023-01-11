package GDSCBackend5.HappyNewYear.server.controller;

import GDSCBackend5.HappyNewYear.server.domain.member.Member;
import GDSCBackend5.HappyNewYear.server.domain.member.SessionConst;
import GDSCBackend5.HappyNewYear.server.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;
    @GetMapping("/")
    public String home(@SessionAttribute(name= SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {
        if (loginMember == null) {
            return "/home";
        }
        model.addAttribute("loginMember", loginMember);
        return "/home";
    }

    @GetMapping("/test/{token}")
    public String test(@PathVariable("token") String token, Model model) {

        model.addAttribute("token", token);
        return "/test";
    }
}
