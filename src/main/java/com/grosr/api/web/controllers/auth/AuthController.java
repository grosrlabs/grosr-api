package com.grosr.api.web.controllers.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.grosr.api.dto.auth.Login;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by grosr on 3/4/17.
 */

@RestController
public class AuthController implements IAuthController {

    @Override
    @RequestMapping(value = "/api/v1/auth/login",method = RequestMethod.POST)
    public Login login(@RequestBody Login payload) {
        String token = "";
        try {
            token = JWT.create()
                    .withIssuer("grosr.api")
                    .withClaim("admin", true)
                    .withJWTId(payload.getUsername())
                    .sign(Algorithm.HMAC256(payload.getUsername()));
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
        } catch (UnsupportedEncodingException ex){

        }
        payload.setPassword(null);
        payload.setToken(token);
    	return payload;
    }

    @Override
    @RequestMapping(value = "/api/v1/auth/logout",method = RequestMethod.GET)
    public String logout() {
        return null;
    }
}
