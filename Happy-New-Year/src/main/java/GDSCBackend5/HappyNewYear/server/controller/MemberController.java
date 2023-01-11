package GDSCBackend5.HappyNewYear.server.controller;

import GDSCBackend5.HappyNewYear.server.domain.member.Member;
import GDSCBackend5.HappyNewYear.server.domain.member.SessionConst;
import GDSCBackend5.HappyNewYear.server.dto.member.MemberLoginRequest;
import GDSCBackend5.HappyNewYear.server.dto.member.MemberSignupRequest;
import GDSCBackend5.HappyNewYear.server.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
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
    public String save(@ModelAttribute MemberSignupRequest request, Model model) {
        model.addAttribute("message", "회원가입이 완료되었습니다.");
        model.addAttribute("searchUrl", "/");

        Member member = new Member();
        member.signup(request.getUserId(), request.getPassword(), request.getName());
        memberService.join(member);

        return "message";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("member", new MemberLoginRequest());
        return "signup/loginForm";
    }
    @PostMapping("/login")
    public String login(@Validated @ModelAttribute MemberLoginRequest loginRequest,
                        BindingResult bindingResult, HttpServletRequest request, Model model) {

        Member loginMember = memberService.authentication(loginRequest.getUserId(), loginRequest.getPassword());

        if (loginMember == null) {
            model.addAttribute("member",loginRequest);
            return "signup/loginForm";
        }
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}