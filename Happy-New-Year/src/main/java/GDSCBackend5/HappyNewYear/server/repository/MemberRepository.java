package GDSCBackend5.HappyNewYear.server.repository;

import GDSCBackend5.HappyNewYear.server.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
