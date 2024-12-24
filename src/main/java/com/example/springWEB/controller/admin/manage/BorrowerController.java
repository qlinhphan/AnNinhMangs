package com.example.springWEB.controller.admin.manage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springWEB.domain.Book;
import com.example.springWEB.service.BookService;

@Controller
public class BorrowerController {

    private BookService bookService;

    public BorrowerController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/admin/borrower")
    public String borrower(Model model) {
        List<Book> listBook = this.bookService.findAllBooks();
        List<Book> dataBook = new ArrayList<>();
        for (Book book : listBook) {
            if (book.getUser() != null) {
                dataBook.add(book);
            }
        }
        model.addAttribute("dataBooks", dataBook);
        return "/admin/TableBorrower";
    }

}
