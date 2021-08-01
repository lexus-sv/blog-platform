package dev.sukhilin.blogplatform.model;

import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;

public class Vote {

  private String ownerId;

  @CreatedDate
  private LocalDateTime creationDate;

  private boolean value;

}
