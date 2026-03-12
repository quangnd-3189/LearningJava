package com.sun.training_java.sdj.demo.books.entity;

import com.sun.training_java.sdj.demo.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book_authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookAuthors extends BaseEntity {
  @Column(nullable = false, name = "book_id")
  private Long bookId;
  @Column(nullable = false, name = "author_id")
  private Long authorId;
}
