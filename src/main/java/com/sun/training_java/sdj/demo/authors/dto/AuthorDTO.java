package com.sun.training_java.sdj.demo.authors.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import com.sun.training_java.sdj.demo.books.dto.BookDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
  private Long id;
  private String name;
  private String email;
  private String phone;
  private List<BookDTO> books;
}
