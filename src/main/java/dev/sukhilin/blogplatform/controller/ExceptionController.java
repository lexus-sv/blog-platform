package dev.sukhilin.blogplatform.controller;

import dev.sukhilin.blogplatform.dto.auth.AuthResponse;
import dev.sukhilin.blogplatform.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(value = {UserNotFoundException.class})
  public ResponseEntity<AuthResponse> responseEntity() {
    return ResponseEntity.ok(AuthResponse.fail());
  }

}
