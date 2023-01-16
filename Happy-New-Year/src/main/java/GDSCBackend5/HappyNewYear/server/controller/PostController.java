package GDSCBackend5.HappyNewYear.server.controller;

import GDSCBackend5.HappyNewYear.server.domain.member.Member;
import GDSCBackend5.HappyNewYear.server.domain.Post;
import GDSCBackend5.HappyNewYear.server.dto.member.MemberSignupRequest;
import GDSCBackend5.HappyNewYear.server.service.MemberService;
import GDSCBackend5.HappyNewYear.server.service.PostService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private MemberService memberService;

    @PostMapping("/writinghome")
    public String postWrite(Post post, Model model) {

        String token = post.getToken();

        Member userByToken = memberService.findUserByToken(token);

        model.addAttribute("token", token);
        model.addAttribute("name", userByToken.getName()+"님의 복주머니");

        post.posting(post.getSender(), post.getTitle(), post.getContent(), token);
        postService.write(post);

        return "writingHome";
    }

    @GetMapping("/test/{token}")
    public String test(@PathVariable("token") String token, HttpServletResponse response, @CookieValue(value = "token",required = false) String cookie, Model model) {
        if (cookie == null||!cookie.equals(token)) {
            Member userByToken = memberService.findUserByToken(token);

            model.addAttribute("token", token);
            model.addAttribute("name", userByToken.getName()+"님의 복주머니");
            return "writingHome";
        }
        else if (cookie.equals(token)) {
            model.addAttribute("postList", postService.viewPostList(token));
            return "/postview";
        }
        return "";
    }

}
