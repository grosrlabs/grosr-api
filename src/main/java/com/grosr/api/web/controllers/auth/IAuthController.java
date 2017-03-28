package com.grosr.api.web.controllers.auth;


import com.grosr.api.domain.account.Account;
import com.grosr.api.dto.auth.Login;
import com.grosr.api.dto.auth.User;

/**
 * Created by rahulchaturvedi on 3/7/17.
 */
public interface IAuthController {

    public User login(Login payload);
    public String logout();

}
