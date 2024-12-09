package com.example.springWEB.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.User;
import com.example.springWEB.dto.request.UserDTO;
import com.example.springWEB.repository.RoleRepository;
import com.example.springWEB.repository.UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public User saveUser(User user) {
        
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
}
