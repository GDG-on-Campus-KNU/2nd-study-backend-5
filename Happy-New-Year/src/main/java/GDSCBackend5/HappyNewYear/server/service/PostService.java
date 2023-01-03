package GDSCBackend5.HappyNewYear.server.service;

import GDSCBackend5.HappyNewYear.server.domain.Member;
import GDSCBackend5.HappyNewYear.server.domain.Post;
import GDSCBackend5.HappyNewYear.server.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Long write(Post post){
        postRepository.save(post);

        return post.getPostid();
    }

    public List<Post> viewPostList(String token) {
        List<Post> posts=postRepository.findByToken(token);

        return posts;
    }
}
