package GDSCBackend5.HappyNewYear.server.controller;

import GDSCBackend5.HappyNewYear.server.domain.member.Member;
import GDSCBackend5.HappyNewYear.server.domain.Post;
import GDSCBackend5.HappyNewYear.server.dto.member.MemberSignupRequest;
import GDSCBackend5.HappyNewYear.server.service.MemberService;
import GDSCBackend5.HappyNewYear.server.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/writinghome")
    public String writingHome(Model model) {
        model.addAttribute("name", "kdozlo"+"님의 복주머니");
        return "writingHome";
    }

    @PostMapping("/writinghome")
    public String postWrite(Post post, Model model) {
        model.addAttribute("name", "kdozlo"+"님의 복주머니");
        post.posting(post.getSender(), post.getTitle(), post.getContent(), "u");
        postService.write(post);

        return "writingHome";
    }
    @Autowired
    private MemberService memberService;
    @GetMapping("/view")
    public String viewPost(Model model) {

        model.addAttribute("postList", postService.viewPostList("0320f5b0-d812-4b01-81a5-3dc94c8ef7df"));
        return "postview";
    }
}
