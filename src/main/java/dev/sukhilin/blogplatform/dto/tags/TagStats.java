package dev.sukhilin.blogplatform.dto.tags;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TagStats {

  private final List<Tag> tags;

}
