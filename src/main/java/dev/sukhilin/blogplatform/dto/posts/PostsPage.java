package dev.sukhilin.blogplatform.dto.posts;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostsPage {

  private long count = 0;
  private List<Object> posts = new ArrayList<>();
}
