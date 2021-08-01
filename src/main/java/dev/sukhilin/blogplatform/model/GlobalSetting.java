package dev.sukhilin.blogplatform.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class GlobalSetting {

  @Id
  private String id;

  private String code;

  private String name;

  private boolean value;


  public static GlobalSetting from(Setting setting) {
    GlobalSetting gs = new GlobalSetting();
    gs.setCode(setting.toString());
    gs.setName(setting.getLabel());
    gs.setValue(setting.getDefaultValue());
    return gs;
  }

}
