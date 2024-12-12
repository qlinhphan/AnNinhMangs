package com.example.springWEB.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springWEB.domain.Author;
import com.example.springWEB.service.AuthorService;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // Hiển thị danh sách tác giả
    @GetMapping("/admin/author")
    public String author(Model model) {
        List<Author> listAuthor = this.authorService.findAllAuthors();
        model.addAttribute("listAuthor", listAuthor);
        return "/admin/TableAuthor";
    }

    // Hiển thị form tạo mới tác giả
    @GetMapping("/admin/author/create")
    public String cAuthor(Model model, @ModelAttribute("newAuthor") Author author) {
        return "/admin/CreateAuthor";
    }

    // Xử lý lưu tác giả mới
    @PostMapping("/createAuthor/ok")
    public String createOk(Model model, @ModelAttribute("newAuthor") Author author) {
        Author newAuthor = new Author();
        newAuthor.setFullName(author.getFullName());
        newAuthor.setBorn(author.getBorn());
        newAuthor.setAddress(author.getAddress());
        newAuthor.setStatus(author.getStatus());
        this.authorService.saveAuthor(newAuthor);
        return "redirect:/admin/author";
    }

    // Hiển thị form chỉnh sửa tác giả
    @GetMapping("/admin/author/edit/{id}")
    public String editAuthor(Model model, @PathVariable int id) {
        Author author = this.authorService.findAuthorById(id);
        model.addAttribute("currentAuthor", author);
        return "/admin/EditAuthor";
    }

    // Xử lý cập nhật thông tin tác giả
    @PostMapping("/editAuthor/ok")
    public String editOk(Model model, @ModelAttribute("currentAuthor") Author author) {
        Author existingAuthor = this.authorService.findAuthorById(author.getId());
        if (existingAuthor != null) {
            existingAuthor.setFullName(author.getFullName());
            existingAuthor.setBorn(author.getBorn());
            existingAuthor.setAddress(author.getAddress());
            existingAuthor.setStatus(author.getStatus());
            this.authorService.saveAuthor(existingAuthor);
        }
        return "redirect:/admin/author";
    }

    // Hiển thị form xóa tác giả
    @GetMapping("/admin/author/delete/{id}")
    public String delAuthor(Model model, @PathVariable int id) {
        Author author = this.authorService.findAuthorById(id);
        model.addAttribute("currentAuthor", author);
        return "/admin/DelAuthor";
    }

    // Xử lý xóa tác giả
    @PostMapping("/deleteAuthor/ok")
    public String deleteOk(@ModelAttribute("currentAuthor") Author author, RedirectAttributes redirectAttributes) {
        this.authorService.deleteAuthorById(author.getId());
        redirectAttributes.addFlashAttribute("message", "Author deleted successfully!");
        return "redirect:/admin/author";
    }

}

