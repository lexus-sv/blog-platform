package dev.sukhilin.blogplatform.dto.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import dev.sukhilin.blogplatform.dto.UserDto;
import dev.sukhilin.blogplatform.model.User;
import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class AuthResponse {

  private boolean result;

  private UserDto user;

  public AuthResponse(boolean result) {
    this.result = result;
  }

  public static AuthResponse success(UserDto user) {
    AuthResponse response = new AuthResponse(true);
    response.setUser(user);
    return response;
  }

  public static AuthResponse fail() {
    return new AuthResponse(false);
  }

}
