package GDSCBackend5.HappyNewYear.server.service;

import GDSCBackend5.HappyNewYear.server.domain.member.Member;
import GDSCBackend5.HappyNewYear.server.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        validateDuplicateUserId(member);
        memberRepository.save(member);

        return member.getId();
    }

    public Member findUser(String userId) {
        List<Member> member = memberRepository.findByUserId(userId);
        return member.get(0);
    }

    private void validateDuplicateUserId(Member member) {
        List<Member> members = memberRepository.findByUserId(member.getUserId());
        if (!(members.isEmpty())) {
            throw new IllegalStateException("동일한 아이디가 이미 존재합니다.");
        }
    }

    public Member authentication(String userId, String password) {
        List<Member> member = memberRepository.findByUserId(userId);

        if (member.isEmpty()) {
            return null;
        }

        if (member.get(0).getPassword().equals(password)) {
            return member.get(0);
        } else return null;
    }
}
