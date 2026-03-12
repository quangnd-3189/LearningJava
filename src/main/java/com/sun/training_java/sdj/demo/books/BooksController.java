package com.sun.training_java.sdj.demo.books;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.representer.BaseRepresenter;

import com.sun.training_java.sdj.demo.common.httpresponse.BaseResponse;
import com.sun.training_java.sdj.demo.common.httpresponse.FailedResponse;
import com.sun.training_java.sdj.demo.common.httpresponse.SuccessResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@Tag(name = "Books", description = "Books management endpoints")
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {
  
  private final BooksService booksService;

  @GetMapping("/")
  public BaseResponse getAllBook() {
    Object result = this.booksService.getBooks();
    return result == null ? new FailedResponse("Not Found") : new SuccessResponse(result, "Success");
  }
  
}
