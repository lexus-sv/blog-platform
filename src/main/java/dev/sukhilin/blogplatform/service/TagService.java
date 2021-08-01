package dev.sukhilin.blogplatform.service;

import dev.sukhilin.blogplatform.dto.tags.TagStats;
import dev.sukhilin.blogplatform.repository.PostRepository;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class TagService {

  private final PostRepository postRepository;

  public TagService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public TagStats getTagStats() {
    return new TagStats(new ArrayList<>());
  }
}
