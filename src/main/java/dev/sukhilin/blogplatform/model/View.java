package dev.sukhilin.blogplatform.model;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

@Data
public class View {

  private String userId;

  @CreatedDate
  private LocalDateTime viewDate;

}
