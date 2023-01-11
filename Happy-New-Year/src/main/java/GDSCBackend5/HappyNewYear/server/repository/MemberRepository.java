package GDSCBackend5.HappyNewYear.server.repository;

import GDSCBackend5.HappyNewYear.server.domain.member.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public List<Member> findByUserId(String userId) {
        return em.createQuery("select m from Member As m where m.userId = :userId", Member.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}
