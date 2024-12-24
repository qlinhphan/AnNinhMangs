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
import com.example.springWEB.service.AuthorService;
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
    ApplicationRunner applicationRunner(RoleRepository roleRepository, UserService userService, AuthorService authorService) {
        return args -> {
            this.createRoleDefault(roleRepository);
            this.createUserDefault(userService);
            this.createAuthorDefault(authorService);

        };
    }

    private void createAuthorDefault(AuthorService authorService) {
        if (authorService.toFindAllAthor().isEmpty() == false) {
            return;
        }

        // Dữ liệu về các tác giả
        String[][] authorsData = {
            {"Thai Binh", "1999", "Nguyen Van a", "tac gia tre tuoi"},
            {"Thanh Hoa", "1997", "Nguyen Manh Hai", "tac gia moi vao nghe"},
            {"Hoa Binh", "2000", "Pham Quang Hung", "tac gia tre tuoi"},
            {"Thai Binh", "1964", "Nguyen Huu Hung", "tac gia ky cuc"},
            {"Thai Binh", "1999", "Le Thi Soan", "tac gia tot bung"},
            {"Da Nang", "1992", "Truong Tan Sang", "tac gia tre tuoi"}
        };

        // Lặp qua dữ liệu và gọi phương thức createAndSaveAuthor
        for (int i = 0; i < authorsData.length; i++) {
            String fullName = authorsData[i][2]; // Tên tác giả
            int birthYear = Integer.parseInt(authorsData[i][1]); // Năm sinh
            String address = authorsData[i][0]; // Địa chỉ
            String status = authorsData[i][3]; // Trạng thái

            // Gọi phương thức createAndSaveAuthor
            if (authorService.createAndSaveAuthor(fullName, birthYear, address, status) == false) {
                System.err.println("[ERROR] - Khởi tạo dữ liệu author ????");
                System.exit(0);
            }
        }

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
