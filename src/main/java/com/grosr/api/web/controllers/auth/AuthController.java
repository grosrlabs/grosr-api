package com.grosr.api.web.controllers.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.grosr.api.dao.authentication.AccountDAO;
import com.grosr.api.domain.authentication.Account;
import com.grosr.api.dto.auth.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by grosr on 3/4/17.
 */

@RestController
public class AuthController implements IAuthController {

    @Autowired
    private AccountDAO accountDAO;

    @Override
    @RequestMapping(value = "/api/v1/auth/login",method = RequestMethod.POST)
    public Account login(@RequestBody Login payload) {
        Date startTime = new Date();
        Account acc = accountDAO.getByUserId(new Long(1));
        Date endTime = new Date();
        System.out.println((endTime.getTime()-startTime.getTime())/1000);
        String token = "";
        if(acc!=null) {
            try {
                token = JWT.create()
                        .withIssuer("grosr.api")
                        .withClaim("admin", true)
                        .withJWTId(acc.getUsername())
                        .sign(Algorithm.HMAC256(acc.getUsername()));
            } catch (JWTCreationException exception) {
                //Invalid Signing configuration / Couldn't convert Claims.
            } catch (UnsupportedEncodingException ex) {

            }
        }

        payload.setPassword(null);
        payload.setToken(token);
        System.out.print(acc.getUsername());
    	return acc;
    }

    @Override
    @RequestMapping(value = "/api/v1/auth/logout",method = RequestMethod.GET)
    public String logout() {
        return null;
    }
}
