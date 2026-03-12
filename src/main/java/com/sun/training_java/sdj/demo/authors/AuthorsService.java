package com.sun.training_java.sdj.demo.authors;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.sun.training_java.sdj.demo.authors.dto.AuthorDTO;
import com.sun.training_java.sdj.demo.authors.entity.Author;
import com.sun.training_java.sdj.demo.books.BookAuthorsRepository;
import com.sun.training_java.sdj.demo.books.dto.BookDTO;
import com.sun.training_java.sdj.demo.books.entity.BookAuthors;
import com.sun.training_java.sdj.demo.common.PageResponse;

import jakarta.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AuthorsService {
  private final AuthorsRepository authorsRepository;
  private final BookAuthorsRepository bookAuthorsRepository;

  public PageResponse<AuthorDTO> getAuthors(int page, int size) {

    Pageable pageable = PageRequest.of(page, size);
    Page<Author> authorPage = authorsRepository.findAll(pageable);
    List<AuthorDTO> dtos = authorPage.getContent()
            .stream()
            .map(this::mapBooksTo)
            .toList();

    return new PageResponse<>(
            dtos,
            authorPage.getNumber(),
            authorPage.getSize(),
            authorPage.getTotalElements(),
            authorPage.getTotalPages()
    );
  }

  public AuthorDTO findAuthorById(Long id) {
    Author author = authorsRepository.findById(id).orElse(null);
    return mapBooksTo(author);
  }

  public AuthorDTO searchAuthor(String name) {
    Author author = authorsRepository.findByName(name);
    return author == null ? null : mapBooksTo(author);
  }

  @Transactional
  public AuthorDTO addOrUpdateAuthor(AuthorDTO input, boolean isUpdate) {
      Author savedAuthor;
    if(isUpdate) {
      Author existingAuthor = authorsRepository.findById(input.getId()).orElse(null);
      if(existingAuthor == null) {
        return null;
      }
      existingAuthor.setName(input.getName());
      existingAuthor.setEmail(input.getEmail());
      existingAuthor.setPhone(input.getPhone());
      savedAuthor = authorsRepository.save(existingAuthor);
    } else {
      Author newAuthor = new Author();
      newAuthor.setName(input.getName());
      newAuthor.setEmail(input.getEmail());
      newAuthor.setPhone(input.getPhone());

      savedAuthor = authorsRepository.save(newAuthor);
    }

    if(input.getBooks() != null && input.getBooks().size() > 0) {
      bookAuthorsRepository.deleteBooksByAuthorId(savedAuthor.getId());
      List<BookAuthors> bookAuthors = input.getBooks()
          .stream()
          .filter(Objects::nonNull)
          .filter(book -> book.getId() != null)
          .map(book -> new BookAuthors(book.getId(), savedAuthor.getId()))
          .toList();
      bookAuthorsRepository.saveAll(bookAuthors);
    }

    return mapBooksTo(savedAuthor);
  }

  @Transactional
  public boolean removeAuthor(Long id) {
    return authorsRepository.removeAuthor(id) > 0;
  }

  private AuthorDTO mapBooksTo(Author author) {
    if(author == null)
      return null;

    List<BookDTO> books = author.getBooks() == null
        ? null
        : author.getBooks()
            .stream()
            .filter(Objects::nonNull)
            .map(book -> new BookDTO(book.getId(), book.getTitle()))
            .collect(Collectors.toList());

    return new AuthorDTO(author.getId(), author.getName(), author.getEmail(), author.getPhone(), books);
  }
}
