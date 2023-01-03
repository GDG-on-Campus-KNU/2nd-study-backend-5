package GDSCBackend5.HappyNewYear.server.service;

import GDSCBackend5.HappyNewYear.server.domain.Member;
import GDSCBackend5.HappyNewYear.server.domain.Post;
import GDSCBackend5.HappyNewYear.server.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
class PostServiceTest {

    @Autowired
    PostService postService;
    @Autowired
    MemberService memberService;


    @Test
    public void 글작성(){
        Post post = new Post();

        post.posting("hi", "bye", "test");

        Long postId = postService.write(post);

        Assertions.assertThat(post.getPostid()).isEqualTo(postId);
    }

    @Test
    public void 글보기(){
        Member member=new Member();
        member.signup("Dawoon98", "1234", "Dawoon");

        memberService.join(member);

        String userToken= member.getToken();

        Post post1 =new Post();
        Post post2 =new Post();
        Post post3 =new Post();

        post1.posting("hi", "bye", "test",userToken);
        post2.posting("Dawn", "bye", "test",userToken);
        post3.posting("DaeYoung", "bye", "test",userToken);

        postService.write(post1);
        postService.write(post2);
        postService.write(post3);

        List<Post>posts=postService.viewPostList(userToken);

        for(Post i:posts)
        {
            Assertions.assertThat(userToken).isEqualTo(i.getToken());
            System.out.printf("%s %s %s\n",i.getSender(),i.getTitle(),i.getContent());
        }

    }
}