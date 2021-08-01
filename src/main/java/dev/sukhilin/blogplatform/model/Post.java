package dev.sukhilin.blogplatform.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Post {

  @Id
  private String id;

  private String ownerId;

  private String title;

  private String text;

  private boolean active;

  private ModerationStatus moderationStatus;

  private List<ModerationLog> moderationLogs;

  @CreatedDate
  private LocalDateTime creationDate;

  @LastModifiedDate
  private LocalDateTime lastModifiedDate;

  private List<View> viewHistory = new ArrayList<>();

  private List<Vote> votes = new ArrayList<>();

  private List<String> tags = new ArrayList<>();
}
