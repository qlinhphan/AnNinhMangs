package com.example.springWEB.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.User;
import com.example.springWEB.domain.dto.UserRegisterDTO;
import com.example.springWEB.dto.request.UserDTO;
import com.example.springWEB.repository.RoleRepository;
import com.example.springWEB.repository.UserRepository;
import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    public User createUserFromDTO(UserDTO userDTO) {
        var user = new User();
        user.setFullName(userDTO.getFullName());
        user.setAddress(userDTO.getAddress());
        user.setBorn(userDTO.getBorn());
        user.setRole(roleRepository.findById(userDTO.getRoleId()).orElseThrow());
        user.setBook(new ArrayList<>());
        return user;
    }

    public Page<User> findAllUsers(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    public User findUserById(int id) {
        var opUser = this.userRepository.findById(id);
        return opUser.orElse(null);
    }

    public void deleteUserById(int id) {
        this.userRepository.deleteById(id);
    }

    public User findUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User convertToUser(UserRegisterDTO urd) {
        User us = new User();
        us.setFullName(urd.getName());
        us.setEmail(urd.getEmail());
        us.setPassword(this.passwordEncoder.encode(urd.getPassword()));
        us.setRole(this.roleRepository.findByName("USER"));
        this.userRepository.save(us);
        return us;
    }
}
