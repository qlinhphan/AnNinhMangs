package com.example.springWEB.service;

import com.example.springWEB.constant.ConstDefaultEntity;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.User;
import com.example.springWEB.domain.dto.UserRegisterDTO;
import com.example.springWEB.dto.request.UserDTO;
import com.example.springWEB.repository.RoleRepository;
import com.example.springWEB.repository.UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public User createUserFromDTO(UserDTO userDTO) {
        var user = createUser(
                userDTO.getFullName(),
                userDTO.getAddress(),
                userDTO.getBorn(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getRoleId()
        );
        return user;
    }

    public User createUserFromDTO(UserRegisterDTO urd) {
        User us = createUser(
                urd.getName(),
                "unknow",
                2000,
                urd.getEmail(),
                urd.getPassword(),
                ConstDefaultEntity.ROLE_ID_USER
        );
        return us;
    }

    private User createUser(String name, String address, int born, String email, String password, int roleId) {

        if (findUserByEmail(email) != null) {
            throw new IllegalArgumentException("Email đã được sử dụng: " + email);
        }

        var user = new User();
        user.setFullName(name);
        user.setAddress(address);
        user.setBorn(born);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(roleRepository.findById(roleId).orElseThrow());
        user.setBook(new ArrayList<>());
        return user;
    }

    public List<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    public User findUserById(int id) {
        var opUser = this.userRepository.findById(id);
        return opUser.orElse(null);
    }

    public void deleteUserById(int id) {
        this.userRepository.deleteById(id);
    }

    public User findUserByEmail(String email) {
        return this.userRepository.findByEmail(email).orElse(null);
    }

}
