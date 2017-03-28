package com.grosr.api.web.controllers.user;

import com.auth0.jwt.JWT;
import com.grosr.api.domain.account.Account;
import com.grosr.api.dto.auth.Login;

/**
 * Created by grosr on 3/7/17.
 */
public interface IUserController {
    JWT me(String token);
    String register(Account account);
    String resetpassword(Login account);

}
