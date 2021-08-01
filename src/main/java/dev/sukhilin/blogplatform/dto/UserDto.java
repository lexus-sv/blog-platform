package dev.sukhilin.blogplatform.dto;

import lombok.Data;

@Data
public class UserDto {

  private String id;
  private String name;
  private String photo;
  private String email;
  private boolean moderation;
  private long moderationCount;
  private boolean settings;

}
