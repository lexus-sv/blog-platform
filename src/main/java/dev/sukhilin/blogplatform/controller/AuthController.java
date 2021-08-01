package dev.sukhilin.blogplatform.controller;

import dev.sukhilin.blogplatform.dto.auth.AuthResponse;
import dev.sukhilin.blogplatform.dto.auth.LoginDto;
import dev.sukhilin.blogplatform.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final AuthenticationService authenticationService;

  public AuthController(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @PostMapping("login")
  public ResponseEntity<AuthResponse> login(@RequestBody LoginDto login) {
    return ResponseEntity.ok(authenticationService.login(login));
  }

  @GetMapping("check")
  public ResponseEntity<AuthResponse> authCheck() {
    return ResponseEntity.ok(authenticationService.authCheck());
  }
}
