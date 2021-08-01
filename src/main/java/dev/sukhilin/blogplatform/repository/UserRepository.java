package dev.sukhilin.blogplatform.repository;

import dev.sukhilin.blogplatform.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

  Optional<User> findByEmail(String email);
}
