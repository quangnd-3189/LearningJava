package com.sun.training_java.sdj.demo.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sun.training_java.sdj.demo.books.entity.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {}
