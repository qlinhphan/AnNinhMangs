package com.example.springWEB.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Override
    public Book save(Book book);

    public Book findById(int id);

    public void deleteById(int id);

    @Override
    public Page<Book> findAll(Pageable pageable);
}
