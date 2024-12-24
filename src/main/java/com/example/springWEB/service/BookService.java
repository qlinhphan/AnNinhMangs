package com.example.springWEB.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Book;
import com.example.springWEB.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return this.bookRepository.save(book);
    }

    public List<Book> findAllBooks() {
        return this.bookRepository.findAll();
    }

    public Book findBookById(int id) {
        return this.bookRepository.findById(id);
    }

    public void deleteBookById(int id) {
        this.bookRepository.deleteById(id);
    }

    public Page<Book> findAllBookss(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }
}
