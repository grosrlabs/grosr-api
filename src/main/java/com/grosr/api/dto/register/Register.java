package com.grosr.api.dto.register;

import java.io.Serializable;

/**
 * Created by grosr on 3/27/17.
 */
public class Register implements Serializable{
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
