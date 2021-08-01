package dev.sukhilin.blogplatform.model;

public enum Permission {
  USER("user:write"),
  MODERATION("user:moderate");

  private final String permission;

  Permission(String permission) {
    this.permission = permission;
  }

  public String getPermission() {
    return permission;
  }
}
