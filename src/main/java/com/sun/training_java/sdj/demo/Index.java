package com.sun.training_java.sdj.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sun.training_java.sdj.demo.authors.AuthorsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class Index {

  private final AuthorsService authorsService;

  @GetMapping("/")
  public String index(Model model) {
		Object result = this.authorsService.getAuthors(0, 10);
    model.addAttribute("authors", result);
    return "authors";
  }

}
