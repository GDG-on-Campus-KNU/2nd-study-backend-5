package GDSCBackend5.HappyNewYear.server.service;

import GDSCBackend5.HappyNewYear.server.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    public void signUp() {
        Member member = new Member();
        member.register("taegon1998", "1234", "taegon");

        Long memberId = memberService.join(member);

        Assertions.assertThat(member.getId()).isEqualTo(memberId);
    }
}