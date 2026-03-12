package com.sun.training_java.sdj.demo.books;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import com.sun.training_java.sdj.demo.books.dto.BookDTO;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BooksService {
  private final BooksRepository booksRepository;

  public List<BookDTO> getBooks() {
    return booksRepository.findAll()
          .stream()
          .map(book -> new BookDTO(book.getId(), book.getTitle()))
          .toList();
  }
}
