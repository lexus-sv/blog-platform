package dev.sukhilin.blogplatform.model;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {
  USER("ROLE_USER", EnumSet.of(Permission.USER)),
  MODERATOR("ROLE_MODERATOR", EnumSet.of(Permission.USER, Permission.MODERATION));

  private final String roleName;
  private final EnumSet<Permission> permissions;

  Role(String roleName, EnumSet<Permission> permissions) {
    this.roleName = roleName;
    this.permissions = permissions;
  }

  public String getRoleName() {
    return roleName;
  }

  public Set<SimpleGrantedAuthority> getAuthorities() {
    return permissions.stream()
        .map(p -> new SimpleGrantedAuthority(p.getPermission()))
        .collect(Collectors.toSet());
  }
}
