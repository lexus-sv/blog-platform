package dev.sukhilin.blogplatform.dto.posts;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PostQueryMode {
  RECENT,
  POPULAR,
  BEST,
  EARLY
}
