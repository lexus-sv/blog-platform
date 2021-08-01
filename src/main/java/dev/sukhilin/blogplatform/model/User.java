package dev.sukhilin.blogplatform.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class User {

  @Id
  private String id;

  private String email;
  private String password;
  private String name;
  private String recoveryCode;
  private String photo;

  private boolean isModerator;

  @CreatedDate
  private LocalDateTime registrationTime;

  public Role getRole() {
    return isModerator ? Role.MODERATOR : Role.USER;
  }
}
