package dev.sukhilin.blogplatform.repository;

import dev.sukhilin.blogplatform.model.GlobalSetting;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SettingsRepository extends MongoRepository<GlobalSetting, String> {

}
