package com.grosr.api.web.controllers.auth;


import com.grosr.api.domain.authentication.Account;
import com.grosr.api.dto.auth.Login;
import com.grosr.api.dto.auth.User;

import java.util.List;

/**
 * Created by rahulchaturvedi on 3/7/17.
 */
public interface IAuthController {

    public Account login(Login payload);
    public String logout();

}
