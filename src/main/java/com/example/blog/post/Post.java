package com.example.blog.post;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Post {
    private Long id;
    private String title;
    private String description;
}
