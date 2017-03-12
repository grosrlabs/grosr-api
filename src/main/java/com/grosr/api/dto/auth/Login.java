package com.grosr.api.dto.auth;

/**
 * Created by grosr on 3/7/17.
 */
public class Login {
    private String username;
    private String password;
    private String token;

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

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
