package GDSCBackend5.HappyNewYear.server.service;

import GDSCBackend5.HappyNewYear.server.domain.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
class PostServiceTest {

    @Autowired
    PostService postService;

    @Test
    public void 글작성(){
        Post post = new Post();

        post.posting("hi", "bye", "test");

        Long postId = postService.write(post);

        Assertions.assertThat(post.getPostid()).isEqualTo(postId);
    }
}