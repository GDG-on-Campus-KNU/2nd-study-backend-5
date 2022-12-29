package GDSCBackend5.HappyNewYear.server.controller;

import GDSCBackend5.HappyNewYear.server.domain.Member;
import GDSCBackend5.HappyNewYear.server.dto.ResponseDto;
import GDSCBackend5.HappyNewYear.server.dto.member.MemberSignupRequest;
import GDSCBackend5.HappyNewYear.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<ResponseDto> saveMember(@Validated @RequestBody MemberSignupRequest request, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(new ResponseDto("공백 에러"));
        }

        Member member = new Member();

        member.signup(request.getUserId(), request.getPassword(), request.getName());
        memberService.join(member);

        return ResponseEntity.ok().body(new ResponseDto("회원가입이 완료되었습니다."));
    }
}
