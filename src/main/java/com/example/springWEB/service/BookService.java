package com.example.springWEB.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Book;
import com.example.springWEB.repository.BookRepository;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

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
}
