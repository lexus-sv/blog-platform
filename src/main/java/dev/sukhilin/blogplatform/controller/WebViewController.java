package dev.sukhilin.blogplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebViewController {

  @RequestMapping("/")
  public String index() {
    return "index";
  }

  @RequestMapping(method = {RequestMethod.OPTIONS, RequestMethod.GET}, value = "/**/{path:[^.]*}")
  public String all() {
    return "forward:/";
  }

}