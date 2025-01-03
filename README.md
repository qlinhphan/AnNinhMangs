# Quản lý giáo trình công nghệ thông tin

## Giới thiệu
Đây là một ứng dụng web quản lý giáo trình công nghệ thông tin, được phát triển bằng Spring Boot. Ứng dụng sử dụng JSP cho giao diện và áp dụng mã hóa hàm băm BCrypt để bảo mật mật khẩu của người dùng.

## Các tính năng chính
- Quản lý người dùng (đăng ký, đăng nhập, chỉnh sửa thông tin cá nhân).
- Quản lý giáo trình (thêm, sửa, xóa, tìm kiếm).
- Phân quyền người dùng (Admin, Giảng viên, Sinh viên).
- Bảo mật mật khẩu bằng mã hóa hàm băm BCrypt.

## Công nghệ sử dụng
- **Spring Boot**: Framework chính.
- **JSP**: Giao diện người dùng.
- **Spring Security**: Cấu hình bảo mật.
- **BCrypt**: Mã hóa mật khẩu.
- **MySQL**: Cơ sở dữ liệu.
- **Hibernate/JPA**: Tầng truy xuất dữ liệu.
- **Bootstrap**: Thiết kế giao diện.

## Yêu cầu hệ thống
- **Java**: Phiên bản 17 hoặc mới hơn.
- **Maven**: Quản lý dependencies.
- **MySQL**: Để lưu trữ dữ liệu.
- **IDE**: NetBeans, IntelliJ IDEA hoặc Eclipse.

## Cài đặt
1. Clone repository này:
   ```bash
   git clone <URL_REPOSITORY>
   ```

2. Cấu hình cơ sở dữ liệu trong file `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/ten_database
   spring.datasource.username=ten_user
   spring.datasource.password=mat_khau
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Build và chạy ứng dụng:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. Truy cập ứng dụng tại: `http://localhost:8086`

## Cấu trúc dự án
```
src
├── main
│   ├── java
│   │   └── com.example.project
│   │       ├── controller    # Xử lý các yêu cầu HTTP
│   │       ├── model         # Các entity JPA
│   │       ├── repository    # Tầng truy xuất dữ liệu
│   │       ├── service       # Xử lý logic nghiệp vụ
│   │       └── security      # Cấu hình Spring Security và BCrypt
│   └── resources
│       ├── templates         # JSP views
│       ├── static            # CSS, JS, hình ảnh
│       └── application.properties
```

## Một số đoạn code chính
### Cấu hình Spring Security
```java
package com.example.springWEB.config;

import com.example.springWEB.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import jakarta.servlet.DispatcherType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public HttpFirewall httpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowSemicolon(true); // Cho phép ký tự ;
        firewall.setAllowUrlEncodedDoubleSlash(true); // Cho phép //
        return firewall;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                .dispatcherTypeMatchers(DispatcherType.FORWARD,
                        DispatcherType.INCLUDE)
                .permitAll()
                .requestMatchers("/", "/login", "/client/**", "/detail/**",
                        "/css/**", "/js/**", "/images/**", "/register")
                .permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated())
                .formLogin(formLogin -> formLogin
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .successHandler(myAuthenticationSuccessHandlers()) // authorization
                .permitAll())
                .exceptionHandling(ex -> ex.accessDeniedPage("/access-deny")); // page not
        // allowed
        // .rememberMe(reM -> reM.key("uniqueAndSecret").tokenValiditySeconds(86400))
        // .logout(logout -> logout.deleteCookies("JSESSIONID"));
        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandlers() {
        return new MyAuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(customUserDetailsService())
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean
    public CustomUserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
```

## Ghi chú
- Luôn sử dụng BCrypt để lưu mật khẩu nhằm tăng cường bảo mật.
- Backup cơ sở dữ liệu định kỳ để tránh mất dữ liệu.

## Đóng góp
Hãy mở Pull Request hoặc tạo Issue nếu bạn muốn đóng góp ý tưởng hoặc báo lỗi.

## Liên hệ
- Cập nhật sau