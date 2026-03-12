package com.sun.training_java.sdj.demo.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sun.training_java.sdj.demo.books.entity.BookAuthors;

public interface BookAuthorsRepository extends JpaRepository<BookAuthors, Long> {

  @Modifying
  @Query("DELETE FROM BookAuthors ba WHERE ba.authorId = :authorId")
  int deleteBooksByAuthorId(@Param("authorId") Long authorId);
}
