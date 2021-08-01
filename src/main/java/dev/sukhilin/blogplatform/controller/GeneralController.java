package dev.sukhilin.blogplatform.controller;

import dev.sukhilin.blogplatform.dto.BlogInitProperties;
import dev.sukhilin.blogplatform.dto.tags.TagStats;
import dev.sukhilin.blogplatform.service.SettingsService;
import dev.sukhilin.blogplatform.service.TagService;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GeneralController {

  private final SettingsService settingsService;
  private final TagService tagService;

  public GeneralController(
      SettingsService settingsService,
      TagService tagService) {
    this.settingsService = settingsService;
    this.tagService = tagService;
  }

  @GetMapping("settings")
  public ResponseEntity<Map<String, Boolean>> getGlobalSettings() {
    return ResponseEntity.ok(settingsService.getSettings());
  }

  @GetMapping("init")
  public ResponseEntity<BlogInitProperties> getInitProperties() {
    return ResponseEntity.ok(settingsService.getBlogInitProperties());
  }

  @GetMapping("tag")
  public ResponseEntity<TagStats> getTagStats() {
    return ResponseEntity.ok(tagService.getTagStats());
  }

}
