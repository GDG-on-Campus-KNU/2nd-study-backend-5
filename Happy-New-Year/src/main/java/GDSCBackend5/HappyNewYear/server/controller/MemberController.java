package GDSCBackend5.HappyNewYear.server.controller;

import GDSCBackend5.HappyNewYear.server.domain.Member;
import GDSCBackend5.HappyNewYear.server.dto.ResponseDto;
import GDSCBackend5.HappyNewYear.server.dto.member.MemberSignupRequest;
import GDSCBackend5.HappyNewYear.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    public String saveMember(Model model) {
        model.addAttribute("member", new MemberSignupRequest());
        return "signup/signupForm";
    }

    @PostMapping("/signup")
    public String save(@Validated @ModelAttribute MemberSignupRequest request, BindingResult bindingResult, Model model) {
        model.addAttribute("message", "회원가입이 완료되었습니다.");
        model.addAttribute("searchUrl", "/");

        if (bindingResult.hasErrors()) {
            return "signup/signupForm";
        }

        Member member = new Member();
        member.signup(request.getUserId(), request.getPassword(), request.getName());

        memberService.join(member);
        return "message";
    }
}
