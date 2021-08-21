package com.example.blog.post;

import com.example.blog.user.User;
import com.example.blog.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void createUserWithPost() {
        User newUser = User.builder()
                .name("new_name")
                .type("type")
                .build();

        userRepository.save(newUser);

        Post newPost = Post.builder()
                .title("title")
                .description("description")
                .user(newUser)
                .build();

        postRepository.save(newPost);

        Post newPost1 = Post.builder()
                .title("title")
                .description("description")
                .user(newUser)
                .build();

        postRepository.save(newPost1);

        newPost.getUser();
    }
}
