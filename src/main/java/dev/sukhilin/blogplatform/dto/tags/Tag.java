package dev.sukhilin.blogplatform.dto.tags;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Tag {

  private final String name;
  private final double weight;
}
