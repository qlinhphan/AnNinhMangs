/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springWEB.controller.admin;

import com.example.springWEB.domain.User;
import com.example.springWEB.dto.request.UserDTO;
import com.example.springWEB.repository.RoleRepository;
import com.example.springWEB.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/user")
public class UserControll {

    @Autowired
    private UserService userService;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserControll(UserService userService, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("")
    public String book(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        Pageable pagea = PageRequest.of(page - 1, 5);
        Page<User> listPage = this.userService.findAllUsers(pagea);
        List<User> listUser = listPage.getContent();
        model.addAttribute("totalPage", listPage.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("listUser", listUser);
        return "admin/TableUser";
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("newUser", new UserDTO());
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/CreateUser";
    }

    @PostMapping("/createUser/ok")
    public String createOk(Model model, @ModelAttribute("newUser") UserDTO userDTO) {
        try {
            var newUser = userService.createUserFromDTO(userDTO);
            System.out.println(newUser.DevToString());
            userService.saveUser(newUser);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "ok";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id, @ModelAttribute("currentUser") User curUser) {
        var user = this.userService.findUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("roles", roleRepository.findAll());
        return "/admin/EditUser";
    }

    @PostMapping("/edit/ok")
    public String editOK(Model model, @RequestParam("userID") Integer userID,
            @ModelAttribute("currentUser") UserDTO userDTO) {
        try {
            var newUser = userService.findUserById(userID);
            newUser.setFullName(userDTO.getFullName());
            newUser.setAddress(userDTO.getAddress());
            newUser.setBorn(userDTO.getBorn());
            newUser.setRole(roleRepository.findById(userDTO.getRoleId()).orElseThrow());

            System.out.println(newUser.DevToString());
            userService.saveUser(newUser);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "ok";
    }

    @GetMapping("/delete/{id}")
    public String delBook(Model model, @PathVariable Integer id) {
        userService.deleteUserById(id);
        return "ok";
    }

}
