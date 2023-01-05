package GDSCBackend5.HappyNewYear.server.controller;

import GDSCBackend5.HappyNewYear.server.domain.Post;
import GDSCBackend5.HappyNewYear.server.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/writinghome")
    public String writingHome(Model model) {
        model.addAttribute("name", "kdozlo"+"님의 복주머니");
        return "writingHome";
    }

    @PostMapping("/postwrite")
    public String postWrite(Post post) {
        post.posting(post.getSender(), post.getTitle(), post.getContent(), "u");
        postService.write(post);

        return "writingHome";
    }
}
