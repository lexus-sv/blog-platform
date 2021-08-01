package dev.sukhilin.blogplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class BlogPlatformApplication {

  public static void main(String[] args) {
    SpringApplication.run(BlogPlatformApplication.class, args);
  }

}
