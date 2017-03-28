package com.grosr.api.dto.auth;

import java.io.Serializable;

/**
 * Created by grosr on 3/7/17.
 */
public class Login implements Serializable{
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
