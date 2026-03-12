package com.sun.training_java.sdj.demo.books.entity;

import java.util.Set;

import com.sun.training_java.sdj.demo.authors.entity.Author;
import com.sun.training_java.sdj.demo.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity {

  @Column(nullable = false, length = 100)
  private String title;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "book_authors",
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id")
  )
  private Set<Author> authors;
}
