package com.sun.training_java.sdj.demo.authors;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.training_java.sdj.demo.authors.dto.AuthorDTO;
import com.sun.training_java.sdj.demo.common.httpresponse.BaseResponse;
import com.sun.training_java.sdj.demo.common.httpresponse.FailedResponse;
import com.sun.training_java.sdj.demo.common.httpresponse.SuccessResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Tag(name = "Authors", description = "Authors management endpoints")
@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorsController {
  private final AuthorsService authorsService;

	@GetMapping("/")
  public BaseResponse getListAuthorsPage(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		Object result = this.authorsService.getAuthors(page, size);
		return result == null ? new FailedResponse("Not Found") : new SuccessResponse(result, "Success");
  }

  @GetMapping("/detail/{id}")
  public BaseResponse findAuthor(@PathVariable Long id) {
		Object result = this.authorsService.findAuthorById(id);
		return result == null ? new FailedResponse("Not Found") : new SuccessResponse(result, "Success");
  }
  
  @GetMapping("/search")
  public BaseResponse searchAuthors(@RequestParam String name) {
		Object result = this.authorsService.searchAuthor(name);
		return result == null ? new FailedResponse("Not Found") : new SuccessResponse(result, "Success");
  }

  @PostMapping("/add")
  public BaseResponse addAuthor(@RequestBody AuthorDTO input) {
		Object result = this.authorsService.addOrUpdateAuthor(input, false);
		return result == null ? new FailedResponse("Not Found") : new SuccessResponse(result, "Success");
  }
  
  @PutMapping("/update")
  public BaseResponse updateAuthor(@RequestBody AuthorDTO input) {
    Object result = this.authorsService.addOrUpdateAuthor(input , true);
    return new SuccessResponse(result, "Success");
  }

  @DeleteMapping("/delete/{id}")
  public BaseResponse removeAuthor(@PathVariable Long id) {
    boolean isRemoved = this.authorsService.removeAuthor(id);
    return isRemoved ? new SuccessResponse(null, "Author removed successfully") : new FailedResponse("Author not found");
  }

}
