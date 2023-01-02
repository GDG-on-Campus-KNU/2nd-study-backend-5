package GDSCBackend5.HappyNewYear.server.repository;

import GDSCBackend5.HappyNewYear.server.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByToken(String token);
}
