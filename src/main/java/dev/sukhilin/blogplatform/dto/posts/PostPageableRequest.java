package dev.sukhilin.blogplatform.dto.posts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostPageableRequest {

  private int offset = 0;
  private int limit = 10;
  private PostQueryMode mode;
}
