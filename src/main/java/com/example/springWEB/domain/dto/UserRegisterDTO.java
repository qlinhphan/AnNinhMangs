package com.example.springWEB.domain.dto;

import lombok.Data;

@Data
public class UserRegisterDTO {

    private String name;
    private String email;
    private String password;
    private String rePassword;

}
