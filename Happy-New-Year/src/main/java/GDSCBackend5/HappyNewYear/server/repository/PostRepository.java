package GDSCBackend5.HappyNewYear.server.repository;

import GDSCBackend5.HappyNewYear.server.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
