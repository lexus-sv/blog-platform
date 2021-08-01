package dev.sukhilin.blogplatform.service;

import dev.sukhilin.blogplatform.dto.UserDto;
import dev.sukhilin.blogplatform.dto.auth.AuthResponse;
import dev.sukhilin.blogplatform.dto.auth.LoginDto;
import dev.sukhilin.blogplatform.exception.UserNotFoundException;
import dev.sukhilin.blogplatform.model.User;
import dev.sukhilin.blogplatform.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

  private final AuthenticationProvider authenticationProvider;
  private final UserRepository userRepository;
  private final PostService postService;

  public AuthenticationService(
      AuthenticationProvider authenticationProvider,
      UserRepository userRepository, PostService postService) {
    this.authenticationProvider = authenticationProvider;
    this.userRepository = userRepository;
    this.postService = postService;
  }

  public AuthResponse login(LoginDto loginDto) {
    try {
      Authentication auth = authenticationProvider.authenticate(
          new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
      SecurityContextHolder.getContext().setAuthentication(auth);
      User user = userRepository.findByEmailIgnoreCase(loginDto.getEmail())
          .orElseThrow(UserNotFoundException::new);
      return AuthResponse.success(asDto(user));
    } catch (AuthenticationException ex) {
     return AuthResponse.fail();
    }
  }

  public AuthResponse authCheck() {
    return AuthResponse.success(asDto(getCurrentUser()));
  }

  public User getCurrentUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return userRepository.findByEmailIgnoreCase(authentication.getName())
        .orElseThrow(UserNotFoundException::new);
  }

  public String getCurrentUserId() {
    return getCurrentUser().getId();
  }

  private UserDto asDto(User user) {
    UserDto dto = new UserDto();
    dto.setId(user.getId());
    dto.setName(user.getName());
    dto.setEmail(user.getEmail());
    dto.setPhoto(user.getPhoto());
    dto.setModeration(user.isModerator());
    dto.setSettings(user.isModerator());
    if (user.isModerator()) {
      dto.setModerationCount(postService.getAmountOfPostsForModeration());
    }
    return dto;
  }
}
