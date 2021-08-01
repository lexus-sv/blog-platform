package dev.sukhilin.blogplatform.controller;

import dev.sukhilin.blogplatform.dto.posts.PostPageableRequest;
import dev.sukhilin.blogplatform.dto.posts.PostsPage;
import dev.sukhilin.blogplatform.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController {

  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping
  public ResponseEntity<PostsPage> getPosts(PostPageableRequest request) {
    return ResponseEntity.ok(postService.getPostsPage(request));
  }
}
