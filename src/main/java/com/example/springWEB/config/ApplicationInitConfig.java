/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springWEB.config;

import com.example.springWEB.constant.ConstDefaultEntity;
import com.example.springWEB.domain.Role;
import com.example.springWEB.domain.User;
import com.example.springWEB.dto.request.UserDTO;
import com.example.springWEB.repository.RoleRepository;
import com.example.springWEB.repository.UserRepository;
import com.example.springWEB.service.UserService;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author KhanhDzai - https://www.facebook.com/khanhdepzai.pro/
 */
@Configuration
public class ApplicationInitConfig {

    @Bean
    ApplicationRunner applicationRunner(RoleRepository roleRepository, UserService userService) {
        return args -> {
            createRoleDefault(roleRepository);
            createUserDefault(userService);

        };
    }

    private void createUserDefault(UserService userService) {
        var email = "admin";
        var pass = "123123";
        if (userService.findUserByEmail(email) == null) {
            var user = new UserDTO();
            user.setEmail(email);
            user.setFullName("admin");
            user.setPassword(pass);
            user.setRoleId(ConstDefaultEntity.ROLE_ID_ADMIN);
            userService.saveUser(userService.createUserFromDTO(user));
        }
    }

    private void createRoleDefault(RoleRepository roleRepository) {
        // Lấy tất cả các role từ cơ sở dữ liệu
        var allRoles = roleRepository.findAll();

        Set<String> existingRole = allRoles.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        for (Map.Entry<String, String> en : ConstDefaultEntity.ROLE_DEFAULT.entrySet()) {
            String name = en.getKey();
            String description = en.getValue();
            if (!existingRole.contains(name)) {
                Role adminRole = new Role();
                adminRole.setName(name);
                adminRole.setDesctiption(description);
                roleRepository.save(adminRole);
            }
        }
    }
}
