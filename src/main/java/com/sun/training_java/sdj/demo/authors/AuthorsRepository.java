package com.sun.training_java.sdj.demo.authors;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sun.training_java.sdj.demo.authors.entity.Author;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Long> {

  Author findOneByName(String name);

  @Query("SELECT a FROM Author a WHERE a.name LIKE %:name%")
  Author findByName(@Param("name") String name);

  @Query("SELECT a FROM Author a LEFT JOIN FETCH a.books WHERE a.deletedAt IS NULL")
  Page<Author> findAll(Pageable pageable);

  @Query("""
    SELECT DISTINCT a
    FROM Author a
    LEFT JOIN FETCH a.books
    WHERE a IN :authors
    """)
  List<Author> fetchBooks(@Param("authors") List<Author> authors);

  // Fix N=1 problem when fetching authors with their books
  @EntityGraph(attributePaths = {"books"})
  List<Author> findAll();

  @Query("SELECT a FROM Author a JOIN FETCH a.books WHERE a.deletedAt IS NULL")
  List<Author> findAllSQL();

  @Modifying
  @Query("UPDATE Author a SET a.deletedAt = CURRENT_TIMESTAMP WHERE a.id = :id")
  int removeAuthor(@Param("id") Long id);
}
