package dev.sukhilin.blogplatform.service;

import dev.sukhilin.blogplatform.dto.posts.PostPageableRequest;
import dev.sukhilin.blogplatform.dto.posts.PostsPage;
import dev.sukhilin.blogplatform.model.ModerationStatus;
import dev.sukhilin.blogplatform.repository.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  private final PostRepository postRepository;

  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public long getAmountOfPostsForModeration() {
    return postRepository.countAllByModerationStatusAndActiveTrue(ModerationStatus.NEW);
  }

  public PostsPage getPostsPage(PostPageableRequest request) {
    return new PostsPage();
  }
}
