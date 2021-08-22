package com.example.blog.post;

import com.example.blog.post.form.PostForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Long postId) {
        return postRepository.findById(postId).orElseThrow(IllegalArgumentException::new);
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    @Transactional
    public void update(Long postId, PostForm postForm) {
        Post post = findById(postId);

        post.setTitle(postForm.getTitle());
        post.setDescription(postForm.getDescription());
    }
}