package GDSCBackend5.HappyNewYear.server.controller;

import GDSCBackend5.HappyNewYear.server.domain.Post;
import GDSCBackend5.HappyNewYear.server.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class WritingPost {
    @Autowired
    private PostService postService;

    @GetMapping("/post/write")
    public String postwriteForm() {
        return "postwrite";
    }

    @PostMapping("/post/wirtepro")
    public String postWritePro(Post post) {
        postService.write(post);

        return "";
    }
}
