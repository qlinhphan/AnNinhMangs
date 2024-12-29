package com.example.springWEB.controller.client;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springWEB.domain.Book;
import com.example.springWEB.domain.User;
import com.example.springWEB.service.BookService;
import com.example.springWEB.service.UserService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomePageBookController {

    private BookService bookService;
    private UserService userService;

    public HomePageBookController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/book")
    public String getMethodName(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
            @AuthenticationPrincipal UserDetails userDetails, HttpSession session) {
        User us = this.userService.findUserByEmail(userDetails.getUsername());
        Pageable pag = PageRequest.of(page - 1, 5);
        Page<Book> listPage = this.bookService.findAllBookss(pag);
        List<Book> listBook = listPage.getContent();
        model.addAttribute("listBook", listBook);
        model.addAttribute("totalPage", Math.max(listPage.getTotalPages(), 1));
        model.addAttribute("currentPage", page);
        session.setAttribute("name", us.getFullName());
        return "/client/PageOrderBook";
    }

    @GetMapping("/borrowBook/{id}")
    public String getBook(Model model, @PathVariable int id, @ModelAttribute("bookBorr") Book books) {
        System.out.println("ID: " + id);
        Book book = this.bookService.findBookById(id);
        model.addAttribute("book", book);
        return "/client/borrowBook";
    }

    @PostMapping("/finish/borr")
    public String finishOk(Model model, @AuthenticationPrincipal UserDetails userDetails,
            @ModelAttribute("bookBorr") Book books) {
        User us = this.userService.findUserByEmail(userDetails.getUsername());
        Book book = this.bookService.findBookById(books.getId());
        book.setUser(us);
        this.bookService.saveBook(book);
        return "redirect:/book";
    }

}
