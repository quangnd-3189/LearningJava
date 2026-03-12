package com.sun.training_java.sdj.demo.authors.entity;

import java.util.List;

import com.sun.training_java.sdj.demo.books.entity.Book;
import com.sun.training_java.sdj.demo.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author extends BaseEntity {
  
  @Column(nullable = false, length = 50)
  private String name;

  @Column(nullable = true, length = 50)
  private String email;
  
  @Column(nullable = true, length = 50)
  private String phone;

  @ManyToMany(mappedBy = "authors")
  private List<Book> books;
}
