/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springWEB.config;

import com.example.springWEB.domain.Role;
import com.example.springWEB.repository.RoleRepository;
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
    ApplicationRunner applicationRunner(RoleRepository roleRepository) {
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
        };
    }
}
