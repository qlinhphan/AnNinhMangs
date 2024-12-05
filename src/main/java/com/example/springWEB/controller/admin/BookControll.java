package com.example.springWEB.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springWEB.domain.Book;
import com.example.springWEB.service.BookService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BookControll {

    private BookService bookService;

    public BookControll(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/admin/book")
    public String book(Model model) {
        List<Book> listBook = this.bookService.findAllBooks();
        model.addAttribute("listBook", listBook);
        return "/admin/TableBook";
    }

    @GetMapping("/admin/book/create")
    public String cBook(Model model, @ModelAttribute("newBook") Book book) {
        return "/admin/CreateBook";
    }

    @PostMapping("/createBook/ok")
    public String createOk(Model model, @ModelAttribute("newBook") Book book) {
        Book bookDif = new Book();
        bookDif.setName(book.getName());
        bookDif.setPublisher(book.getPublisher());
        bookDif.setYear(book.getYear());
        bookDif.setShortDes(book.getShortDes());
        bookDif.setDetailDes(book.getDetailDes());
        this.bookService.saveBook(bookDif);
        return "ok";
    }

    @GetMapping("/edit/{id}")
    public String editBook(Model model, @PathVariable int id, @ModelAttribute("currentBook") Book booke) {
        Book book = this.bookService.findBookById(id);
        model.addAttribute("book", book);
        return "/admin/EditBook";
    }

    @PostMapping("/editF")
    public String editF(Model model, @ModelAttribute("currentBook") Book book) {
        Book bok = this.bookService.findBookById(book.getId());
        if (bok != null) {
            bok.setName(book.getName());
            bok.setPublisher(book.getPublisher());
            bok.setYear(book.getYear());
            bok.setShortDes(book.getShortDes());
            bok.setDetailDes(book.getDetailDes());
        }
        this.bookService.saveBook(bok);
        return "ok";
    }

    @GetMapping("/delBook/{id}")
    public String delBook(Model model, @PathVariable int id, @ModelAttribute("ObjDel") Book book) {
        Book bok = this.bookService.findBookById(id);
        model.addAttribute("bok", bok);
        return "/admin/DelBook";
    }

    @PostMapping("/delBookOk")
    public String postMethodName(Model model, @ModelAttribute("ObjDel") Book book) {
        this.bookService.deleteBookById(book.getId());
        return "ok";
    }

}
