package dev.sukhilin.blogplatform.model;

import org.bson.types.ObjectId;

public class Comment {

  private String id = new ObjectId().toString();
  private String ownerId;
  
}
