package dev.sukhilin.blogplatform.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BlogInitProperties {

  private final String title;
  private final String subtitle;
  private final String phone;
  private final String email;
  private final String copyright;
  private final String copyrightFrom;

}
