package com.grosr.api.web.controllers.user;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.grosr.api.dto.auth.User;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by grosr on 3/4/17.
 */
@RestController
public class UserController implements IUserController{

    @Override
    @RequestMapping(value = "/api/v1/me", method = RequestMethod.GET)
    public JWT me(@RequestHeader(value = "token") String token) {
        JWT jwt = null;
        try {
            jwt = JWT.decode(token);
        } catch (JWTDecodeException exception){
            //Invalid token
        }
        return jwt;
    }
}
