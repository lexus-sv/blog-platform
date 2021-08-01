package dev.sukhilin.blogplatform.dto.posts;

import org.springframework.core.convert.converter.Converter;

public class StringToPostQueryModeConverter implements Converter<String, PostQueryMode> {

  @Override
  public PostQueryMode convert(String s) {
    return PostQueryMode.valueOf(s.toUpperCase());
  }
}
