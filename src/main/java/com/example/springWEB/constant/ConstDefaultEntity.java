/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springWEB.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author KhanhDzai - https://www.facebook.com/khanhdepzai.pro/
 */
public class ConstDefaultEntity {

    public static final String PREFIX_ROLE = "ROLE_";

    public static final Map<String, String> ROLE_DEFAULT;

    public static final Map<String, String> ROLE_TARGET_URL_WHEN_LOGIN_DONE;

    public static final int ROLE_ID_USER;
    public static final int ROLE_ID_ADMIN;

    static {
        final String user = "USER";
        final String admin = "ADMIN";
        ROLE_DEFAULT = new HashMap<>() {
            {
                this.put(user, "Người dùng");
                this.put(admin, "Quản trị viên");
            }
        };
        List<String> roleKeys = new ArrayList<>(ROLE_DEFAULT.keySet());

        ROLE_ID_USER = roleKeys.indexOf(user) + 1;
        ROLE_ID_ADMIN = roleKeys.indexOf(admin) + 1;

        ROLE_TARGET_URL_WHEN_LOGIN_DONE = new HashMap<>() {
            {
                this.put(PREFIX_ROLE + user, "/book");
                this.put(PREFIX_ROLE + admin, "/admin");
            }
        };
    }

}
