package com.example.springWEB.controller.admin.manage;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.springWEB.domain.Author;
import com.example.springWEB.domain.Book;
import com.example.springWEB.service.AuthorService;
import com.example.springWEB.service.BookService;

import jakarta.servlet.ServletContext;

@Controller
public class BookControll {

    private BookService bookService;
    private ServletContext servletContext;
    private AuthorService authorService;

    public BookControll(BookService bookService, ServletContext servletContext, AuthorService authorService) {
        this.bookService = bookService;
        this.servletContext = servletContext;
        this.authorService = authorService;
    }

    @GetMapping("/admin/book")
    public String book(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        System.out.println("PAGE IS: " + page);
        Pageable pag = PageRequest.of(page - 1, 5);
        Page<Book> listBookPage = this.bookService.findAllBookss(pag);
        List<Book> listBook = listBookPage.getContent();
        model.addAttribute("totalPage", listBookPage.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("listBook", listBook);
        return "/admin/TableBook";
    }

    @GetMapping("/admin/book/create")
    public String cBook(Model model, @ModelAttribute("newBook") Book book) {
        return "/admin/CreateBook";
    }

    @PostMapping("/createBook/ok")
    public String createOk(Model model, @ModelAttribute("newBook") Book book,
            @RequestParam("file") MultipartFile file) {
        Book bookDif = new Book();
        bookDif.setName(book.getName());
        bookDif.setPublisher(book.getPublisher());
        bookDif.setYear(book.getYear());
        bookDif.setShortDes(book.getShortDes());
        bookDif.setDetailDes(book.getDetailDes());
        String linkBook = "";
        try {
            byte[] bytes;
            bytes = file.getBytes();

            String rootPath = this.servletContext.getRealPath("/resources/linkBook");

            File dir = new File(rootPath + File.separator + "FILE");

            if (!dir.exists()) {
                dir.mkdirs();
            }

            File serverFile = new File(dir.getAbsolutePath() + File.separator
                    + file.getOriginalFilename());
            linkBook = file.getOriginalFilename();

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        bookDif.setLinkBook(linkBook);
        bookDif.setAuthor(this.authorService.findAuthorByName(book.getAuthor().getFullName()));
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
