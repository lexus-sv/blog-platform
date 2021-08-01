package dev.sukhilin.blogplatform.model;

public enum Setting {

  MULTIUSER_MODE("Многопользовательский режим", true),
  POST_PREMODERATION("Премодерация постов", false),
  STATISTICS_IS_PUBLIC("Показывать всем статистику блога", true);

  private final String label;
  private final boolean defaultValue;

  Setting(String label, boolean defaultValue) {
    this.label = label;
    this.defaultValue = defaultValue;
  }

  public String getLabel() {
    return label;
  }

  public boolean getDefaultValue() {
    return defaultValue;
  }
}
