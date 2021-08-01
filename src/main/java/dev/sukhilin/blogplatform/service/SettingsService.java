package dev.sukhilin.blogplatform.service;

import dev.sukhilin.blogplatform.dto.BlogInitInfo;
import dev.sukhilin.blogplatform.model.GlobalSetting;
import dev.sukhilin.blogplatform.model.Setting;
import dev.sukhilin.blogplatform.repository.SettingsRepository;
import java.util.EnumSet;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SettingsService {

  private final SettingsRepository settingsRepository;

  private final BlogInitInfo blogInitInfo;

  public SettingsService(
      SettingsRepository settingsRepository,
      @Value("${blogInfo.title}") String title,
      @Value("${blogInfo.subtitle}") String subtitle,
      @Value("${blogInfo.phone}") String phone,
      @Value("${blogInfo.email}") String email,
      @Value("${blogInfo.copyright}") String copyright,
      @Value("${blogInfo.copyrightFrom}") String copyrightFrom
  ) {
    this.settingsRepository = settingsRepository;
    this.blogInitInfo = new BlogInitInfo(title, subtitle, phone, email, copyright, copyrightFrom);
  }

  @PostConstruct
  private void initSettingsIfNotPresent() {
    if (settingsRepository.count() == 0) {
      settingsRepository.saveAll(
          EnumSet.allOf(Setting.class).stream()
              .map(GlobalSetting::from)
              .collect(Collectors.toSet())
      );
    }
  }

  public Map<String, Boolean> getSettings() {
    return settingsRepository.findAll().stream()
        .collect(Collectors.toMap(GlobalSetting::getCode, GlobalSetting::isValue));
  }

  public BlogInitInfo getBlogInitValues() {
    return blogInitInfo;
  }
}
