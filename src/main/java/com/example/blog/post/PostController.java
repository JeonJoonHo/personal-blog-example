package com.example.blog.post;

import com.example.blog.post.form.PostForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postService.findAll());

        return "post/index";
    }

    @GetMapping("/posts/{postId}")
    public String show(@PathVariable Long postId, Model model) {
        Post post = postService.findById(postId);
        model.addAttribute("post", post);

        return "post/show";
    }

    @GetMapping("/new-post")
    public String newPost(Model model) {
        model.addAttribute("postForm", new PostForm());

        return "post/new";
    }

    @PostMapping("/new-post")
    public String create(@Valid PostForm postForm, Errors errors) {
        if (errors.hasErrors()) {
            return "post/new";
        }

        Post post = Post.builder()
                .title(postForm.getTitle())
                .description(postForm.getDescription())
                .build();
        postService.save(post);

        return "redirect:/posts";
    }

    @GetMapping("/edit-post/{postId}")
    public String edit(@PathVariable Long postId, Model model) {
        Post post = postService.findById(postId);
        model.addAttribute("post", post);

        PostForm postForm = new PostForm();
        postForm.setTitle(post.getTitle());
        postForm.setDescription(post.getDescription());
        model.addAttribute("postForm", postForm);

        return "post/edit";
    }

    @PostMapping("/edit-post/{postId}")
    public String edit(@PathVariable Long postId, PostForm postForm) {
        postService.update(postId, postForm);
        return "redirect:/posts";
    }
}
