package GDSCBackend5.HappyNewYear.server.service;

import GDSCBackend5.HappyNewYear.server.domain.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    public void 회원가입() {
        Member member = new Member();
        member.signup("taegon1998", "1234", "taegon");

        Long memberId = memberService.join(member);

        Assertions.assertThat(member.getId()).isEqualTo(memberId);
    }

    @Test(expected = IllegalStateException.class)
    public void 아이디중복검사() {
        Member member1 = new Member();
        Member member2 = new Member();

        member1.signup("taegon1999", "1234", "taegon1");
        member2.signup("taegon1999", "12345", "taegon2");

        memberService.join(member1);
        memberService.join(member2);

        fail("예외 발생 필요");
    }

    @Test
    public void 로그인() {
        Member member1 = new Member();
        Member member2 = new Member();

        member1.signup("taegon1999", "1234", "taegon1");
        member2.signup("taegon2000", "12345", "taegon2");

        memberService.join(member1);
        memberService.join(member2);

        Member auth = memberService.authentication(member1.getUserId(), member1.getPassword());

        Assertions.assertThat(auth).isEqualTo(member1);
    }
}