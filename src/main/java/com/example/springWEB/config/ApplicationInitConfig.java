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

            // Lấy tất cả các role từ cơ sở dữ liệu
            var allRoles = roleRepository.findAll();

            // Tạo 2 biến boolean để kiểm tra sự tồn tại của role USER và ADMIN
            boolean hasUserRole = false;
            boolean hasAdminRole = false;

            // Duyệt danh sách role để kiểm tra
            for (Role role : allRoles) {
                if ("USER".equals(role.getName())) {
                    hasUserRole = true;
                }
                if ("ADMIN".equals(role.getName())) {
                    hasAdminRole = true;
                }
                // Nếu đã tìm thấy cả 2 role thì không cần duyệt tiếp
                if (hasUserRole && hasAdminRole) {
                    break;
                }
            }

            // Nếu chưa có role USER, tạo mới và lưu vào cơ sở dữ liệu
            if (!hasUserRole) {
                Role userRole = new Role();
                userRole.setName("USER");
                userRole.setDesctiption("Người dùng");
                roleRepository.save(userRole);
            }

            // Nếu chưa có role ADMIN, tạo mới và lưu vào cơ sở dữ liệu
            if (!hasAdminRole) {
                Role adminRole = new Role();
                adminRole.setName("ADMIN");
                adminRole.setDesctiption("Quản trị viên");
                roleRepository.save(adminRole);
            }

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
