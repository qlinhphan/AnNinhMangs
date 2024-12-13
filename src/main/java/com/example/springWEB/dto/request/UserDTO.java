/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springWEB.dto.request;

import lombok.Data;

/**
 *
 * @author KhanhDzai - https://www.facebook.com/khanhdepzai.pro/
 */
@Data
public class UserDTO {
    
    private String fullName;
    private String address;
    private int born;
    private String email;
    private String password;
    private int roleId;

}
