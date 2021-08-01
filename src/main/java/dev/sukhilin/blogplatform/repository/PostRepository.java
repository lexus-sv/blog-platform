package dev.sukhilin.blogplatform.repository;

import dev.sukhilin.blogplatform.model.ModerationStatus;
import dev.sukhilin.blogplatform.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
  long countAllByModerationStatusAndActiveTrue(ModerationStatus moderationStatus);
}
