package com.grosr.api.web.controllers.user;

import com.auth0.jwt.JWT;
import com.grosr.api.dto.auth.User;

/**
 * Created by grosr on 3/7/17.
 */
public interface IUserController {
    JWT me(String token);

}
